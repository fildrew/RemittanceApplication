package com.mastercard.RemittanceApplication.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recipient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer recipientId;

    @NotEmpty(message = "Recipient Name Can't Be Blank...")
    public String recipientName;

    @NotEmpty(message = "Recipient Address Can't Be Blank...")
    public String recipientAddress;

    public LocalDate recipientDateOfBirth;

    @NotEmpty(message = "Recipient Phone Number Can't Be Blank...")
    public String recipientPhoneNumber;

    @OneToMany(mappedBy = "recipient",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RecipientBankAccount> recipientBankAccounts;
}
