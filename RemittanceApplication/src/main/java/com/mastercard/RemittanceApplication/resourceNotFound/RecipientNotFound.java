package com.mastercard.RemittanceApplication.resourceNotFound;

public class RecipientNotFound extends RuntimeException{

    public RecipientNotFound(String message) {
        super(message);
    }
}