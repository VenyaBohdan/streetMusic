package com.street.interlayer.service.impl;

import com.street.interlayer.model.Wallet;
import com.street.interlayer.service.WalletService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class WalletServiceImpl implements WalletService {

    @Value("${payment.server.url}")
    private String paymentServerUrl;
    private final String WALLET = "wallet/";

    @Override
    public Wallet getWalletById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(paymentServerUrl + WALLET + id, Wallet.class);
    }

    @Override
    public List<Wallet> getAllWallets() {
        RestTemplate restTemplate = new RestTemplate();
        Wallet[] walletResponse = restTemplate.getForObject(paymentServerUrl + WALLET, Wallet[].class);
        return walletResponse == null ? Collections.emptyList() : Arrays.asList(walletResponse);
    }

    @Override
    public Wallet saveWallet(Wallet wallet) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(paymentServerUrl + WALLET, wallet, Wallet.class).getBody();
    }

    @Override
    public void deleteWallet(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(paymentServerUrl + WALLET + id);
    }
}
