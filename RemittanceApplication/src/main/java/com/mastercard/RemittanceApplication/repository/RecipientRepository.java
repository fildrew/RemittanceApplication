package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Integer> {


}
