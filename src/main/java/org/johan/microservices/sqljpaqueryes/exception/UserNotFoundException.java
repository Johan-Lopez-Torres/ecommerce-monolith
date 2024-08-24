package org.johan.microservices.sqljpaqueryes.exception;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super("user with: " + message + "not found");
    }
}
