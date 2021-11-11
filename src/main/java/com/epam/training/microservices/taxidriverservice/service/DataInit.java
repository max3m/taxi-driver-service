package com.epam.training.microservices.taxidriverservice.service;

import com.epam.training.microservices.taxidriverservice.model.Driver;
import com.epam.training.microservices.taxidriverservice.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DataInit  implements ApplicationRunner {
    private final DriverRepository driverRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = driverRepository.count();

        if(count == 0) {
            for (int i = 0; i < 10; i++) {
                Driver driver = new Driver("Driver" + i, "Driver" + i + "@mail.ru");
                driverRepository.save(driver);
            }
        }
    }
}
