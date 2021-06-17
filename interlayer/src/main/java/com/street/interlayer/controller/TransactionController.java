package com.street.interlayer.controller;

import com.street.interlayer.model.Transaction;
import com.street.interlayer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        if (transaction != null) {
            return ResponseEntity.ok(transactionService.saveTransaction(transaction));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBand(@PathVariable String id) {
        transactionService.deleteTransaction(id);
    }

}
