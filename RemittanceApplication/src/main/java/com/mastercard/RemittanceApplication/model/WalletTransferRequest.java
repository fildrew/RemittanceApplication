package com.mastercard.RemittanceApplication.model;

import java.math.BigDecimal;

import com.mastercard.RemittanceApplication.enums.WalletType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransferRequest {

    private WalletType fromWalletType;

    private WalletType toWalletType;

    private BigDecimal amount;
}
