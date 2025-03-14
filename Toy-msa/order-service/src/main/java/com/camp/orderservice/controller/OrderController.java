package com.camp.orderservice.controller;

import com.camp.orderservice.dto.OrderDto;
import com.camp.orderservice.jpa.OrderEntity;
import com.camp.orderservice.messagequeue.KafkaProducer;
import com.camp.orderservice.messagequeue.OrderProducer;
import com.camp.orderservice.service.OrderService;
import com.camp.orderservice.vo.RequestOrder;
import com.camp.orderservice.vo.ResponseOrder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/order-service")
@Slf4j
public class OrderController {
    Environment env;
    OrderService orderService;
    KafkaProducer kafkaProducer;

    OrderProducer orderProducer;

    @Autowired
    public OrderController(Environment env, OrderService orderService,
                           KafkaProducer kafkaProducer, OrderProducer orderProducer) {
        this.env = env;
        this.orderService = orderService;
        this.kafkaProducer = kafkaProducer;
        this.orderProducer = orderProducer;
    }

    @GetMapping("/health-check")
    public String status() {
        return String.format("It's Working in Order Service on LOCAL PORT %s (SERVER PORT %s)",
                env.getProperty("local.server.port"),
                env.getProperty("server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<Map<String, String>> createOrder(@PathVariable("userId") String userId,
                                                           @RequestBody RequestOrder orderDetails) {
        log.debug("Before add orders data");
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        OrderDto orderDto = mapper.map(orderDetails, OrderDto.class);
        try {
            if (!orderService.isOrderAvailable(orderDto)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Collections.singletonMap("msg", "Unable to place order due to insufficient quantity."));
            }
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Collections.singletonMap("msg", "Unavailable catalog service."));
        }
        orderDto.setUserId(userId);
        /* jpa */
        // OrderDto createdOrder = orderService.createOrder(orderDto);
        // ResponseOrder responseOrder = mapper.map(createdOrder, ResponseOrder.class);
        ResponseOrder responseOrder = mapper.map(orderDto, ResponseOrder.class);

        /* kafka */
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDetails.getQty() * orderDetails.getUnitPrice());

        /* send this order to the kafka */
        kafkaProducer.send("example-catalog-topic", orderDto);
        orderProducer.send("example-order-topic", orderDto);

        log.debug("After added orders data");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap("msg", "Order placed successfully."));
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId) throws Exception {
        log.info("Before retrieve orders data");
        Iterable<OrderEntity> orderList = orderService.getOrdersByUserId(userId);

        List<ResponseOrder> result = new ArrayList<>();
        orderList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseOrder.class));
        });

        // try {
        //     Random rnd = new Random();
        //     int value = rnd.nextInt(5);
        //     if (value % 2 == 0) {
        //         Thread.sleep(10000);
        //         throw new Exception("장애 발생");
        //     }
        // } catch (InterruptedException ex) {
        //     log.warn(ex.getMessage());
        // }

        log.info("Add retrieved orders data");

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
