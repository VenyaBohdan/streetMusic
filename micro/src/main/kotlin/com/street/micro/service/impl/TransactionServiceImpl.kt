package com.street.micro.service.impl

import com.street.micro.entity.Transaction
import com.street.micro.repository.TransactionRepository
import com.street.micro.repository.WalletRepository
import com.street.micro.service.TransactionService
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

@Component
class TransactionServiceImpl(
    private val transactionRepository: TransactionRepository,
    private val walletRepository: WalletRepository
) : TransactionService {

    override fun getAllTransactions(): List<Transaction> {
        return transactionRepository.findAll()
    }

    override fun getTransactionById(id: String): Transaction {
        return transactionRepository.findOneById(ObjectId(id))
    }

    override fun saveTransaction(transaction: Transaction): Transaction {
        val savedTransaction = transactionRepository.insert(transaction)
        if (transaction.recipientWallet != null) {
            val wallet = walletRepository.findOneById(transaction.recipientWallet)
            wallet.amount += transaction.amount
            wallet.transactionIds.toMutableList().add(savedTransaction.id)
            walletRepository.insert(wallet)
        }
        return savedTransaction
    }

}