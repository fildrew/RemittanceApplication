package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.ConvertedInto;
import com.mastercard.RemittanceApplication.model.CurrencyType;

import java.util.List;

public interface IConvertedInto {

    public ConvertedInto saveConvertedInto(ConvertedInto convertedInto);

    public ConvertedInto updateConvertedInto(ConvertedInto convertedInto);

    public List<ConvertedInto> getAllConvertedIntoDetails();

    public ConvertedInto findConvertedIntoById(int id);

    public String deleteConvertedIntoDetails(int id);
}
