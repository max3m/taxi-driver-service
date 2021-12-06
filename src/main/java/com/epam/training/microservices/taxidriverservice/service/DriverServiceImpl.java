package com.epam.training.microservices.taxidriverservice.service;

import com.epam.training.microservices.taxidriverservice.exceptions.DriverNotFoundNotException;
import com.epam.training.microservices.taxidriverservice.model.Order;
import com.epam.training.microservices.taxidriverservice.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final OrderClient orderClient;

    @Override
    public boolean checkIfDriverExists(String username) {
        return driverRepository.existsDriverByUsername(username);
    }

    @Override
    public Order updateOrder(Long chainId, Order order) {
        if (checkIfDriverExists(order.getDriverUsername())) {
            order.setId(chainId);
            order.setChainId(chainId);
            return orderClient.sendOrderUpdateRequest(chainId, order);
        } else {
            throw new DriverNotFoundNotException(order.getDriverUsername());
        }
    }
}
