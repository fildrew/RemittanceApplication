package com.mastercard.RemittanceApplication.resourceNotFound;

public class UserBankDetailsNotFound  extends RuntimeException{

    public UserBankDetailsNotFound(String message) {
        super(message);
    }
}
