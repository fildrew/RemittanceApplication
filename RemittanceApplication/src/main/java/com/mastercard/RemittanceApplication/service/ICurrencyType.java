package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.CurrencyType;

import java.util.List;

public interface ICurrencyType {

    public CurrencyType saveCurrency(CurrencyType currencyType);

    public CurrencyType updateCurrency(CurrencyType currencyType);

    public List<CurrencyType> getAllCurrencyDetails();

    public CurrencyType findCurrencyDetailsById(int id);

    public String deleteCurrencyDetails(int id);
}
