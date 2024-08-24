package org.johan.microservices.sqljpaqueryes.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order with ID " + id + " not found.");
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
