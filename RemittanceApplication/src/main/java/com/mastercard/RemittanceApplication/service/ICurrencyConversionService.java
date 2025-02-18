package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.Rate;

import java.math.BigDecimal;
import java.util.List;

public interface ICurrencyConversionService {

    public BigDecimal convertAmount(BigDecimal amount, Integer currencyTypeId, Integer convertedTypeId);

    public List<Rate> fetchAllRatesByCurrencyType(Integer currencyTypeId);
}
