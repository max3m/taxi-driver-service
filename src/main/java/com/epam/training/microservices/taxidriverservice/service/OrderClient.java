package com.epam.training.microservices.taxidriverservice.service;

import com.epam.training.microservices.taxidriverservice.model.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("order-service")
public interface OrderClient {

    @GetMapping("/api/orders")
    List<OrderDTO> getUnassignedOrders();

    @PutMapping("/api/orders/{id}")
    OrderDTO sendOrderUpdateRequest(@PathVariable("id") Long id, @RequestBody OrderDTO order);
}

