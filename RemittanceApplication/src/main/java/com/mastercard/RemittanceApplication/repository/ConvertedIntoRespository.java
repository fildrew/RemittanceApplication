package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.ConvertedInto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvertedIntoRespository extends JpaRepository<ConvertedInto, Integer> {
}
