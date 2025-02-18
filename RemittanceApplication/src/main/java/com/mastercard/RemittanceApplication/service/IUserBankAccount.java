package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.UserBankAccount;

import java.util.List;

public interface IUserBankAccount {

    public List<UserBankAccount> getAllUserBankDetails();

    public UserBankAccount saveUserBankAccountDetails(UserBankAccount userBankAccount);

    public UserBankAccount updateUserBankAccountDetails(UserBankAccount updateUserBankAccount);

    public UserBankAccount findUserBankAccountDetailsById(int id);

    public String deleteUserBankAccountDetails(int id);
}