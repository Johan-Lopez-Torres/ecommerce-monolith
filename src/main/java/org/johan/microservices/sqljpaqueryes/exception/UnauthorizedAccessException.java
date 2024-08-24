package org.johan.microservices.sqljpaqueryes.exception;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super("Unauthorized Access: " + message + "is not allowed");
    }
}
