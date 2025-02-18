package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.Rate;

import java.math.BigDecimal;
import java.util.List;

public interface IRateService {

    public Rate saveConversionRate(Rate rate);

    public Rate updateConversionRate(Rate rate);

    public List<Rate> getAllConversionRateDetails();

    public Rate findConversionRateDetailsById(int id);

    public String deleteConversionRateDetails(int id);

    public void updateRate(int rateId, BigDecimal newRate);
}
