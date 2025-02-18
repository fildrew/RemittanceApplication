package com.mastercard.RemittanceApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.RemittanceApplication.model.WalletReceipt;
import com.mastercard.RemittanceApplication.repository.WalletReceiptRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WalletReceiptServiceImpl implements IWalletReceiptService{

    @Autowired
    private WalletReceiptRepository walletReceiptRepository;

    @Override
    public List<WalletReceipt> getAllWalletReceipt() {
        return walletReceiptRepository.findAll();
    }

}