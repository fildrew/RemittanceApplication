package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.Receipt;
import com.mastercard.RemittanceApplication.model.TransferRequest;

import java.math.BigDecimal;

public interface ITransactionService {

    public Receipt transferMoney(Integer senderAccountId, Integer receiverAccountId, BigDecimal amount);

    public Receipt transferMoneyUserToRecipient(String userAccountNumber, String userIFSCCode, String recipientAccountNumber, String recipientIFSCCode, BigDecimal amount);
}
