package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.ConvertedInto;
import com.mastercard.RemittanceApplication.model.CurrencyType;
import com.mastercard.RemittanceApplication.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Integer> {

    public List<Rate> findByCurrencyType(CurrencyType currencyType);

    public Rate findByConvertedInto(ConvertedInto convertedInto);

    public Rate findByCurrencyTypeAndConvertedInto(CurrencyType currencyType,ConvertedInto convertedInto);
}
