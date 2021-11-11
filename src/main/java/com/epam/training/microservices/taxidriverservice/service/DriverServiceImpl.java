package com.epam.training.microservices.taxidriverservice.service;

import com.epam.training.microservices.taxidriverservice.exceptions.DriverNotFoundNotException;
import com.epam.training.microservices.taxidriverservice.model.OrderDTO;
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
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        if (checkIfDriverExists(orderDTO.getDriverUsername())) {
            return orderClient.sendOrderUpdateRequest(id, orderDTO);
        } else {
            throw new DriverNotFoundNotException(orderDTO.getDriverUsername());
        }
    }
}
