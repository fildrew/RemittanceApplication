package com.mastercard.RemittanceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mastercard.RemittanceApplication.model.Receipt;

public interface ReceiptRepository  extends JpaRepository<Receipt, Integer>{

}
