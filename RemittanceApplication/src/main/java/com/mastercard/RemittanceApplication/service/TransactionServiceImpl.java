package com.mastercard.RemittanceApplication.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import com.mastercard.RemittanceApplication.model.AmountTransferConfigurationPage;
import com.mastercard.RemittanceApplication.model.Receipt;
import com.mastercard.RemittanceApplication.model.RecipientBankAccount;
import com.mastercard.RemittanceApplication.model.TransferRequest;
import com.mastercard.RemittanceApplication.model.UserBankAccount;
import com.mastercard.RemittanceApplication.repository.ReceiptRepository;
import com.mastercard.RemittanceApplication.repository.RecipientBankAccountRepository;
import com.mastercard.RemittanceApplication.repository.UserBankAccountRepository;
import com.mastercard.RemittanceApplication.resourceNotFound.InsufficientFundException;
import com.mastercard.RemittanceApplication.resourceNotFound.InvalidAccountException;
import com.mastercard.RemittanceApplication.resourceNotFound.RecipientBankAccountNotFound;
import com.mastercard.RemittanceApplication.resourceNotFound.UserBankDetailsNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService{

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private UserBankAccountRepository userBankAccountRepository;

    @Autowired
    private RecipientBankAccountRepository recipientBankAccountRepository;

    @Autowired
    private IAmountTransferConfigurationPageService amountTransferConfigurationPageService;

    @Override
    public Receipt transferMoney(Integer senderAccountId, Integer receiverAccountId, BigDecimal amount) {

        UserBankAccount senderBankAccount = userBankAccountRepository.findById(senderAccountId)
                .orElseThrow(()-> new UserBankDetailsNotFound("Sender Bank Account is Not Found..."));

        UserBankAccount receiverBankAccount = userBankAccountRepository.findById(receiverAccountId)
                .orElseThrow(()-> new UserBankDetailsNotFound("Receiver Bank Account is Not Found..."));

        debit(senderBankAccount, amount);
        credit(receiverBankAccount, amount);

        Receipt receipt = new Receipt();

        receipt.setSenderName(senderBankAccount.getSaveuser().getFullName());

        receipt.setReceiverName(receiverBankAccount.getSaveuser().getFullName());

        receipt.setSenderBankAccount(senderBankAccount.getAccountNumber());

        receipt.setReceiverBankAccount(receiverBankAccount.getAccountNumber());

        receipt.setDateAndTime(LocalDateTime.now());

        receipt.setAmountTransfer(amount);

        receiptRepository.save(receipt);

        return receipt;
    }

    //BigDecimal.ZERO - The value 0, with a scale of 0.
    private void debit(UserBankAccount account, BigDecimal amount)
    {
        BigDecimal newBalance = account.getAccountBalance().subtract(amount);

        if(newBalance.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new InsufficientFundException("Insufficient Funds In the Sender Account...");
        }

        account.setAccountBalance(newBalance);

        userBankAccountRepository.save(account);
    }

    private void credit(UserBankAccount account,BigDecimal amount)
    {
        account.setAccountBalance(account.getAccountBalance().add(amount));

        userBankAccountRepository.save(account);
    }

    @Override
    public Receipt transferMoneyUserToRecipient(String userAccountNumber, String userIFSCCode,
                                               String recipientAccountNumber,String recipientIFSCCode, BigDecimal amount) {

        UserBankAccount userBankAccount = userBankAccountRepository.findByAccountNumberAndIFSCCode(userAccountNumber, userIFSCCode)
                .orElseThrow(()-> new UserBankDetailsNotFound("User Bank Details Are Not Found with:"+userAccountNumber+" or with IFSC Code::"+userIFSCCode));

        RecipientBankAccount recipientBankAccount = recipientBankAccountRepository.findByRecipientBankAccountNumberAndRecipientBankIFSCCode(recipientAccountNumber, recipientIFSCCode)
                .orElseThrow(()-> new RecipientBankAccountNotFound("Recipient Bank Account Details Are Not Found With:"+recipientAccountNumber+" or with IFSC Code::"+recipientIFSCCode));

        AmountTransferConfigurationPage configuration = amountTransferConfigurationPageService.getLatestConfiguration();

        if(amount.compareTo(configuration.getMinAmountTransfer())< 0
                || amount.compareTo(configuration.getMaxAmountTransfer())> 0) {
            throw new IllegalArgumentException("Transfer Amount should be More than 100 and Less than 1000");
        }
        if(userBankAccount.getAccountBalance().compareTo(amount) > 0)
        {
            userBankAccount.setAccountBalance(userBankAccount.getAccountBalance().subtract(amount));

            recipientBankAccount.setRecipientAccountBalance(recipientBankAccount.getRecipientAccountBalance().add(amount));

            userBankAccountRepository.save(userBankAccount);

            recipientBankAccountRepository.save(recipientBankAccount);

            Receipt receipt = new Receipt();

            receipt.setSenderName(userBankAccount.getSaveuser().getFullName());

            receipt.setReceiverName(recipientBankAccount.getRecipient().getRecipientName());

            receipt.setSenderBankAccount(userBankAccount.getAccountNumber());

            receipt.setReceiverBankAccount(recipientBankAccount.getRecipientBankAccountNumber());

            receipt.setAmountTransfer(amount);

            receipt.setUserIFSCCode(userBankAccount.getIFSCCode());

            receipt.setRecipientIFSCCode(recipientBankAccount.getRecipientBankIFSCCode());

            receipt.setDateAndTime(LocalDateTime.now());

            receiptRepository.save(receipt);

            return receipt;
        }
        else
        {
            throw new InsufficientFundException("Insufficient Funds In The Sender Account");
        }

    }

}
