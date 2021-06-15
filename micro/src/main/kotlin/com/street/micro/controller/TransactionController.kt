package com.street.micro.controller

import com.street.micro.entity.Transaction
import com.street.micro.repository.TransactionRepository
import com.street.micro.service.TransactionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}