package com.street.micro.service

import com.street.micro.entity.Transaction
import org.springframework.stereotype.Service

@Service
interface TransactionService {

    fun getTransactionById(id: String): Transaction
    fun getAllTransactions(): List<Transaction>
    fun saveTransaction(transaction: Transaction): Transaction

}