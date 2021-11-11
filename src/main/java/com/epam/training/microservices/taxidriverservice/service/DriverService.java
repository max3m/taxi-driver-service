package com.epam.training.microservices.taxidriverservice.service;

import com.epam.training.microservices.taxidriverservice.model.OrderDTO;

public interface DriverService {
    boolean checkIfDriverExists(String username);
    OrderDTO updateOrder(Long id, OrderDTO orderDTO);
}
