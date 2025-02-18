package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.Receipt;
import com.mastercard.RemittanceApplication.repository.ReceiptRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReceiptServiceImpl implements IReceiptService{

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public List<Receipt> getAllBankReceipt() {
        return receiptRepository.findAll();
    }
}
