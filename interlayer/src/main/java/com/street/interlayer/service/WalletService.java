package com.street.interlayer.service;

import com.street.interlayer.model.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WalletService {

    Wallet getWalletById(String id);
    List<Wallet> getAllWallets();
    Wallet saveWallet(Wallet wallet);
    void deleteWallet(String id);

}
