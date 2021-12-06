package com.epam.training.microservices.taxidriverservice.service;

import com.epam.training.microservices.taxidriverservice.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("order-service")
public interface OrderClient {

    @GetMapping("/api/orders")
    List<Order> getUnassignedOrders();

    @PutMapping("/api/orders/{chainId}")
    Order sendOrderUpdateRequest(@PathVariable("chainId") Long chainId, @RequestBody Order order);
}

