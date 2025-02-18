package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.AmountTransferConfigurationPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountTransferConfigurationPageRepository extends JpaRepository<AmountTransferConfigurationPage, Integer> {

    public AmountTransferConfigurationPage findFirstByOrderByAmountTransferIdDesc();
}
