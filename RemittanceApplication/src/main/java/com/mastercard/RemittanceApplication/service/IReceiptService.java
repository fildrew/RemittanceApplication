package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.Receipt;

import java.util.List;

public interface IReceiptService {

    public List<Receipt> getAllBankReceipt();
}
