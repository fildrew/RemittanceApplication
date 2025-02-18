package com.mastercard.RemittanceApplication.resourceNotFound;

public class InvalidAccountException extends RuntimeException{

    public InvalidAccountException(String message) {
        super(message);
    }

}