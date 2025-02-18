package com.mastercard.RemittanceApplication.resourceNotFound;

public class RecipientBankAccountNotFound extends RuntimeException{

    public RecipientBankAccountNotFound(String message) {
        super(message);
    }
}