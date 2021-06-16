package com.street.interlayer.service.impl;

import com.street.interlayer.model.Transaction;
import com.street.interlayer.service.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Value("${payment.server.url}")
    private String paymentServerUrl;
    private final String TRANSACTION = "transaction/";

    @Override
    public Transaction getTransactionById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(paymentServerUrl + TRANSACTION + id, Transaction.class);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        RestTemplate restTemplate = new RestTemplate();
        Transaction[] transactionResponse = restTemplate.getForObject(paymentServerUrl + TRANSACTION, Transaction[].class);
        return transactionResponse == null ? Collections.emptyList() : Arrays.asList(transactionResponse);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(paymentServerUrl + TRANSACTION, transaction, Transaction.class).getBody();
    }

    @Override
    public void deleteTransaction(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(paymentServerUrl + TRANSACTION + id);
    }
}
