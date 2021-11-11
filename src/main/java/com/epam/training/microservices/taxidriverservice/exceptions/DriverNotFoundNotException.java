package com.epam.training.microservices.taxidriverservice.exceptions;

public class DriverNotFoundNotException extends RuntimeException {

    public DriverNotFoundNotException(String driverUsername) { super("Driver " + driverUsername + " not found"); }
    public DriverNotFoundNotException() {}
}
