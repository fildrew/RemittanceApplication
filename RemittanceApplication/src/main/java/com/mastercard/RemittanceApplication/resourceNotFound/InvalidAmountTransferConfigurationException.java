package com.mastercard.RemittanceApplication.resourceNotFound;

public class InvalidAmountTransferConfigurationException extends RuntimeException{

    public InvalidAmountTransferConfigurationException(String message) {
        super(message);
    }
}