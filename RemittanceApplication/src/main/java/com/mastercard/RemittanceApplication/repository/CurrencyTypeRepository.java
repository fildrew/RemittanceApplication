package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Integer> {
}
