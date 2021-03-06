package com.street.interlayer.service.impl;

import com.street.interlayer.model.Account;
import com.street.interlayer.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    private final String ACCOUNT = "account/";

    @Override
    public Account getAccountById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + ACCOUNT + id, Account.class);
    }

    @Override
    public List<Account> getAllAccounts() {
        RestTemplate restTemplate = new RestTemplate();
        Account[] accountResponse = restTemplate.getForObject(backendServerUrl + ACCOUNT, Account[].class);
        return accountResponse == null ? Collections.emptyList() : Arrays.asList(accountResponse);
    }

    @Override
    public Account saveAccount(Account account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + ACCOUNT, account, Account.class).getBody();
    }

    @Override
    public void deleteAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + ACCOUNT + id);
    }
}
