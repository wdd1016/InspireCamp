package com.camp.orderservice.client;

import com.camp.orderservice.error.FeignErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog-service", configuration = FeignErrorDecoder.class)
public interface CatalogServiceClient {

    @GetMapping("/catalog-service/catalog/count/{productId}")
    ResponseEntity<Integer> getCatalog(@PathVariable String productId);
}
