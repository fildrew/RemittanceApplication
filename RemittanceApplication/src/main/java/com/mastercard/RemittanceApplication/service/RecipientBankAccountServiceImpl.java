package com.mastercard.RemittanceApplication.service;


import com.mastercard.RemittanceApplication.model.RecipientBankAccount;
import com.mastercard.RemittanceApplication.repository.RecipientBankAccountRepository;
import com.mastercard.RemittanceApplication.resourceNotFound.RecipientBankAccountNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipientBankAccountServiceImpl implements IRecipientBankAccountService{

    @Autowired
    private RecipientBankAccountRepository recipientBankAccountRepository;

    @Override
    public RecipientBankAccount saveRecipientBankAccount(RecipientBankAccount recipientBankAccount) {
        return recipientBankAccountRepository.save(recipientBankAccount);
    }

    @Override
    public List<RecipientBankAccount> getAllRecipientBankAccountDetails() {
        return recipientBankAccountRepository.findAll();
    }

    @Override
    public RecipientBankAccount findRecipientBankAccountById(int id) {
        Optional<RecipientBankAccount> optionalRecipientBankAccount  = recipientBankAccountRepository.findById(id);
        return optionalRecipientBankAccount.orElseThrow(()-> new RecipientBankAccountNotFound("Recipient Bank Account Not Found With Id:"+id));
    }

    @Override
    public RecipientBankAccount updateRecipientBankAccount(RecipientBankAccount recipientBankAccount) {
        return recipientBankAccountRepository.save(recipientBankAccount);
    }

    @Override
    public String deleteRecipientBankAccountDetailsById(int id) {
        recipientBankAccountRepository.deleteById(id);
        return "Recipient Bank Account With Id:"+id+" Deleted Successfully...";
    }

    @Override
    public List<RecipientBankAccount> getByRecipientId(int recipientId) {
        return recipientBankAccountRepository.findByRecipient_RecipientId(recipientId);
    }
}
