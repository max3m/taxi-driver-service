package com.epam.training.microservices.taxidriverservice.service;

import com.epam.training.microservices.taxidriverservice.model.Order;

public interface DriverService {
    boolean checkIfDriverExists(String username);
    Order updateOrder(Long chainId, Order order);
}
