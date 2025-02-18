package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.RecipientBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipientBankAccountRepository extends JpaRepository<RecipientBankAccount, Integer> {

    public Optional<RecipientBankAccount> findByRecipientBankAccountNumber(String recipientBankAccountNumber);

    public Optional<RecipientBankAccount>
    findByRecipientBankAccountNumberAndRecipientBankIFSCCode
            (String recipientBankAccountNumber,String recipientIfscCode);

    public List<RecipientBankAccount> findByRecipient_RecipientId(int id);
}
