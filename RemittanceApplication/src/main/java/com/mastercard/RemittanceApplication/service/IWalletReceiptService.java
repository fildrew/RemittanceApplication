package com.mastercard.RemittanceApplication.service;


import com.mastercard.RemittanceApplication.model.WalletReceipt;

import java.util.List;

public interface IWalletReceiptService {

    public List<WalletReceipt> getAllWalletReceipt();
}