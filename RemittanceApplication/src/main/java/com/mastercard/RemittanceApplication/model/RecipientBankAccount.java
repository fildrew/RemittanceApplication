package com.mastercard.RemittanceApplication.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipientbankaccount")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipientBankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipientBankAccountId;

    @NotEmpty(message = "Recipient Bank Name Can't Be Blank...")
    private String recipientBankName;

    @NotEmpty(message = "Recipient Bank Account Number Can't Be Blank...")
    private String recipientBankAccountNumber;

    @NotEmpty(message = "Recipient Bank IFSC Code Can't Be Blank...")
    private String recipientBankIFSCCode;

    private BigDecimal recipientAccountBalance;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

}