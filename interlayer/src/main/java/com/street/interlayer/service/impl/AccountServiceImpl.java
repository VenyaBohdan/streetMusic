package com.street.interlayer.service.impl;

import com.street.interlayer.model.Account;
import com.street.interlayer.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountServiceImpl implements AccountService {

    @Value("${backend.server.url}")
    private String backendServiceUrl;

    @Override
    public Account getAccountById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServiceUrl + "/account/" + id, Account.class);
    }
}
