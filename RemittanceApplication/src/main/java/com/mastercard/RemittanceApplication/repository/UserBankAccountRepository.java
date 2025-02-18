package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.UserBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserBankAccountRepository extends JpaRepository<UserBankAccount, Integer> {

    public Optional<UserBankAccount> findByAccountNumber(String accountNumber);

    public Optional<UserBankAccount> findByAccountNumberAndIFSCCode(String accountNumber,String ifscCode);
}
