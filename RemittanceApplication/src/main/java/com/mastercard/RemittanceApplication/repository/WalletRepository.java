package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.enums.WalletType;
import com.mastercard.RemittanceApplication.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    public Wallet findByWalletTypeAndRegisteredMobileNumber(WalletType walletType,String registeredMobileNumber);

    public Wallet findByWalletType(WalletType walletType);
}
