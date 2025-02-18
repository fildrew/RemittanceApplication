package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.ConvertedInto;
import com.mastercard.RemittanceApplication.model.CurrencyType;
import com.mastercard.RemittanceApplication.model.Rate;
import com.mastercard.RemittanceApplication.repository.ConvertedIntoRespository;
import com.mastercard.RemittanceApplication.repository.CurrencyTypeRepository;
import com.mastercard.RemittanceApplication.repository.RateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class CurrencyConversionServiceImpl implements ICurrencyConversionService{

    @Autowired
    private CurrencyTypeRepository currencyTypeRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private ConvertedIntoRespository convertedIntoRespository;

    @Override
    public BigDecimal convertAmount(BigDecimal amount, Integer currencyTypeId, Integer convertedTypeId) {

        CurrencyType currencyType = currencyTypeRepository.findById(currencyTypeId)
                .orElseThrow(()->new RuntimeException("Currency Type Not Found..."));

        ConvertedInto convertedInto = convertedIntoRespository.findById(convertedTypeId)
                .orElseThrow(()->new RuntimeException("Converted Into Type Not Found..."));

        Rate rate = rateRepository.findByCurrencyTypeAndConvertedInto(currencyType, convertedInto);
        if(rate != null)
        {
            return amount.multiply(rate.getConversionRate());
        }
        else
        {
            throw new RuntimeException("Conversion Rate Not Found...");
        }

    }

    @Override
    public List<Rate> fetchAllRatesByCurrencyType(Integer currencyTypeId) {
        CurrencyType currencyType = currencyTypeRepository.findById(currencyTypeId)
                .orElseThrow(()-> new RuntimeException("Currency Type is Not Found..."));
        return rateRepository.findByCurrencyType(currencyType);
    }

}
