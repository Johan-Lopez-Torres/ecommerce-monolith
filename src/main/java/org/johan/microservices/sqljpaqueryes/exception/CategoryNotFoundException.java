package org.johan.microservices.sqljpaqueryes.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super("Category with: " + message + " not found.");
    }
}