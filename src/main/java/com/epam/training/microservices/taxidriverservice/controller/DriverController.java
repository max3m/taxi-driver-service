package com.epam.training.microservices.taxidriverservice.controller;

import com.epam.training.microservices.taxidriverservice.model.OrderDTO;
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
    public List<OrderDTO> getListOfUnassignedOrders() {
        return orderClient.getUnassignedOrders();
    }

    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO sendOrderUpdateRequest(@PathVariable("id") Long id, @RequestBody OrderDTO orderDTO){
        return driverService.updateOrder(id, orderDTO);
    }
}
