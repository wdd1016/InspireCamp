package com.camp.orderservice.service;

import com.camp.orderservice.client.CatalogServiceClient;
import com.camp.orderservice.dto.OrderDto;
import com.camp.orderservice.jpa.OrderEntity;
import com.camp.orderservice.jpa.OrderRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CatalogServiceClient catalogServiceClient;
    private final EurekaClient eurekaClient;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CatalogServiceClient catalogServiceClient, EurekaClient eurekaClient) {
        this.orderRepository = orderRepository;
        this.catalogServiceClient = catalogServiceClient;
        this.eurekaClient = eurekaClient;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity orderEntity = mapper.map(orderDto, OrderEntity.class);

        orderRepository.save(orderEntity);

        OrderDto returnValue = mapper.map(orderEntity, OrderDto.class);

        return returnValue;
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        OrderDto orderDto = new ModelMapper().map(orderEntity, OrderDto.class);

        return orderDto;
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public boolean isOrderAvailable(OrderDto orderDto) {
        String productId = orderDto.getProductId();

        ResponseEntity<Integer> response = catalogServiceClient.getCatalog(productId);
        Integer availableStock = response.getBody();
        if (availableStock != null) {
            return availableStock >= orderDto.getQty();
        }
        return false;
    }

    @Override
    public String getOrderServiceInstanceId() {
        InstanceInfo instanceInfo = eurekaClient.getApplicationInfoManager().getInfo();
        if (instanceInfo != null) {
            return instanceInfo.getInstanceId();
        }
        return "";
    }


}
