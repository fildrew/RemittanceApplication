package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.enums.WalletType;
import com.mastercard.RemittanceApplication.model.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface IWalletService {

    public Wallet saveWallet(Wallet wallet);

    public List<Wallet> getAllWalletDetails();

    public Wallet updateWalletDetails(Wallet wallet);

    public Wallet getWalletByType(WalletType walletType);

    public void updateBalance(WalletType walletType, BigDecimal amount);

    public String transferMoney(WalletType fromWalletType, WalletType toWalletType,
                                String fromRegisterMobileNumber,String toRegisterMobileNumber,BigDecimal amount);

    public String transferMoneyOfDiffCurrencies(WalletType fromWalletType, WalletType toWalletType,BigDecimal amount,
                                                String fromRegisterMobileNumber,String toRegisterMobileNumber,Integer currencyFrom,Integer currencyTo);

    public String addFundsFromBank(WalletType walletType,Integer userBankAccountId,BigDecimal amount);
}