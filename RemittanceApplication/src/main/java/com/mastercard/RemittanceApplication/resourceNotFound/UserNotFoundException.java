package com.mastercard.RemittanceApplication.resourceNotFound;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
