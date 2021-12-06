package com.epam.training.microservices.taxidriverservice.controller;

import com.epam.training.microservices.taxidriverservice.model.Order;
import com.epam.training.microservices.taxidriverservice.service.DriverService;
import com.epam.training.microservices.taxidriverservice.service.OrderClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DriverController {
    private final DriverService driverService;
    private final OrderClient orderClient;

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getListOfUnassignedOrders() {
        return orderClient.getUnassignedOrders();
    }

    @PutMapping("/orders/{chainId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order sendOrderUpdateRequest(@PathVariable("chainId") Long chainId, @RequestBody Order order){
        return driverService.updateOrder(chainId, order);
    }
}
