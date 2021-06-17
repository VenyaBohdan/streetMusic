package com.street.interlayer.service.impl;

import com.street.interlayer.model.Account;
import com.street.interlayer.model.Wallet;
import com.street.interlayer.service.AccountService;
import com.street.interlayer.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class WalletServiceImpl implements WalletService {

    @Autowired
    private AccountService accountService;

    @Value("${payment.server.url}")
    private String paymentServerUrl;
    private final String WALLET = "wallet/";

    @Override
    public Wallet getWalletById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        Wallet wallet = restTemplate.getForObject(paymentServerUrl + WALLET + id, Wallet.class);
        Account account = accountService.getAccountById(wallet.getOwnerId());
        wallet.setAccount(account);
        wallet.getTransactions().forEach(transaction -> {
            Account transactionAcc = accountService.getAccountById(transaction.getAuthorId());
            transaction.setAccount(transactionAcc);
        });
        return wallet;
    }

    @Override
    public List<Wallet> getAllWallets() {
        RestTemplate restTemplate = new RestTemplate();
        Wallet[] walletResponse = restTemplate.getForObject(paymentServerUrl + WALLET, Wallet[].class);
        List<Wallet> wallets = walletResponse == null ? Collections.emptyList() : Arrays.asList(walletResponse);
        wallets.forEach(wallet -> {
            Account account = accountService.getAccountById(wallet.getOwnerId());
            wallet.setAccount(account);
            wallet.getTransactions().forEach(transaction -> {
                Account transactionAcc = accountService.getAccountById(transaction.getAuthorId());
                transaction.setAccount(transactionAcc);
            });
        });
        return wallets;
    }

    @Override
    public Wallet saveWallet(Wallet wallet) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(paymentServerUrl + WALLET, wallet, Wallet.class).getBody();
    }

    @Override
    public void deleteWallet(String id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(paymentServerUrl + WALLET + id);
    }
}
