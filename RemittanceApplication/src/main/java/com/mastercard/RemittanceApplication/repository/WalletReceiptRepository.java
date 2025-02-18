package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.WalletReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletReceiptRepository extends JpaRepository<WalletReceipt, Integer> {
}
