package com.street.interlayer.service.impl;

import com.street.interlayer.model.Account;
import com.street.interlayer.model.Transaction;
import com.street.interlayer.service.AccountService;
import com.street.interlayer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountService accountService;

    @Value("${payment.server.url}")
    private String paymentServerUrl;
    private final String TRANSACTION = "transaction/";

    @Override
    public Transaction getTransactionById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        Transaction transaction = restTemplate.getForObject(paymentServerUrl + TRANSACTION + id, Transaction.class);
        Account account = accountService.getAccountById(transaction.getAuthorId());
        transaction.setAccount(account);
        return transaction;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        RestTemplate restTemplate = new RestTemplate();
        Transaction[] transactionResponse = restTemplate.getForObject(paymentServerUrl + TRANSACTION, Transaction[].class);
        List<Transaction> transactions = transactionResponse == null ? Collections.emptyList() : Arrays.asList(transactionResponse);
        transactions.forEach(transaction -> {
            Account account = accountService.getAccountById(transaction.getAuthorId());
            transaction.setAccount(account);
        });
        return transactions;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(paymentServerUrl + TRANSACTION, transaction, Transaction.class).getBody();
    }

    @Override
    public void deleteTransaction(String id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(paymentServerUrl + TRANSACTION + id);
    }
}
