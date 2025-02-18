package com.mastercard.RemittanceApplication.service;

import java.util.List;
import java.util.Optional;
import com.mastercard.RemittanceApplication.model.AmountTransferConfigurationPage;

public interface IAmountTransferConfigurationPageService {

    public AmountTransferConfigurationPage
    saveAmountTransferConfigurationPage(AmountTransferConfigurationPage amountTransferConfigurationPage);

    public List<AmountTransferConfigurationPage> getAllTransferConfigurationPage();

    public Optional<AmountTransferConfigurationPage> findAmountTransferConfigurationPageById(int id);

    public void
    updateAmountTransferConfigurationPage(AmountTransferConfigurationPage amountTransferConfigurationPage);

    public String deleteAmountTransferConfigurationPage(int id);

    public AmountTransferConfigurationPage getAmountTransferConfiguration();

    public AmountTransferConfigurationPage getLatestConfiguration();

}
