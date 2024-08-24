package org.johan.microservices.sqljpaqueryes.exception;

public class UserAlreadyExistsException  extends RuntimeException{

        public UserAlreadyExistsException(String message){
            super("User with the name " + message + " already exists.");
        }
}
