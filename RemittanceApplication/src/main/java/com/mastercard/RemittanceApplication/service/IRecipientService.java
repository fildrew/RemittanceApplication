package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.Recipient;

import java.util.List;

public interface IRecipientService {

    public Recipient saveRecipient(Recipient recipient);

    public List<Recipient> getAllRecipient();

    public Recipient updateRecipient(Recipient recipient);

    public Recipient findRecipientById(int id);

    public String deleteRecipientById(int id);
}
