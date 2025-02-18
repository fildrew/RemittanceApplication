package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.RecipientBankAccount;

import java.util.List;

public interface IRecipientBankAccountService {

    public RecipientBankAccount saveRecipientBankAccount(RecipientBankAccount recipientBankAccount);

    public List<RecipientBankAccount> getAllRecipientBankAccountDetails();

    public RecipientBankAccount findRecipientBankAccountById(int id);

    public RecipientBankAccount updateRecipientBankAccount(RecipientBankAccount recipientBankAccount);

    public String deleteRecipientBankAccountDetailsById(int id);

    public List<RecipientBankAccount> getByRecipientId(int recipientId);
}
