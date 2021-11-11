package com.epam.training.microservices.taxidriverservice.repository;

import com.epam.training.microservices.taxidriverservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    boolean existsDriverByUsername(String username);
}
