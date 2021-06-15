package com.street.interlayer.service;

import com.street.interlayer.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    Transaction getTransactionById(Long id);
    List<Transaction> getAllTransactions();
    Transaction saveTransaction(Transaction transaction);
    void deleteTransaction(Long id);
}
