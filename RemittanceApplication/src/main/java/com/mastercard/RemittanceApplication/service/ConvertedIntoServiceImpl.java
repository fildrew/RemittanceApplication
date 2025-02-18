package com.mastercard.RemittanceApplication.service;

import com.mastercard.RemittanceApplication.model.ConvertedInto;
import com.mastercard.RemittanceApplication.repository.ConvertedIntoRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ConvertedIntoServiceImpl implements IConvertedInto{

    @Autowired
    private ConvertedIntoRespository convertedIntoRespository;

    @Override
    public ConvertedInto saveConvertedInto(ConvertedInto convertedInto) {
        return convertedIntoRespository.save(convertedInto);
    }

    @Override
    public ConvertedInto updateConvertedInto(ConvertedInto convertedInto) {
        return convertedIntoRespository.save(convertedInto);
    }

    @Override
    public List<ConvertedInto> getAllConvertedIntoDetails() {
        return convertedIntoRespository.findAll();
    }

    @Override
    public ConvertedInto findConvertedIntoById(int id) {
        return convertedIntoRespository.findById(id).orElseThrow(()-> new RuntimeException("Converted Into is not Found with Id:"+id));
    }

    @Override
    public String deleteConvertedIntoDetails(int id) {
        convertedIntoRespository.deleteById(id);
        return "Converted Into Information Deleted Successfully:"+id;
    }

}
