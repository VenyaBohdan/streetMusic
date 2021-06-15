package com.street.micro.controller

import com.street.micro.entity.Transaction
import com.street.micro.repository.TransactionRepository
import com.street.micro.service.TransactionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transaction")
class TransactionController(
    private val transactionService: TransactionService
) {
    @GetMapping
    fun getAllTransactions() : ResponseEntity<List<Transaction>> {
        val transactions = transactionService.getAllTransactions()
        return ResponseEntity.ok(transactions)
    }

    @GetMapping("/{id}")
    fun getTransactionById(@PathVariable id: String): ResponseEntity<Transaction> {
        return ResponseEntity.ok(transactionService.getTransactionById(id))
    }

    @PostMapping
    fun saveTransaction(@RequestBody transaction: Transaction): Transaction {
        return transactionService.saveTransaction(transaction)
    }

    @DeleteMapping("/{id}")
    fun deleteTransaction(@PathVariable id: String) {
        transactionService.deleteTransaction(id)
    }
}