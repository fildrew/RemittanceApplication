package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.Recipient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipientServiceImpl implements IRecipientService{

    @Autowired
    private RecipientRepository recipientRepository;

    @Override
    public Recipient saveRecipient(Recipient recipient) {
        return recipientRepository.save(recipient);
    }

    @Override
    public List<Recipient> getAllRecipient() {
        return recipientRepository.findAll();
    }

    @Override
    public Recipient updateRecipient(Recipient recipient) {
        return recipientRepository.save(recipient);
    }

    @Override
    public Recipient findRecipientById(int id) {
        Optional<Recipient> optionalRecipient = recipientRepository.findById(id);
        return optionalRecipient.orElseThrow(()-> new RecipientNotFound("Recipient Not Found With Id:"+id));
    }

    @Override
    public String deleteRecipientById(int id) {
        recipientRepository.deleteById(id);
        return "Recipient Deleted Successfully with Id:"+id;
    }



}
