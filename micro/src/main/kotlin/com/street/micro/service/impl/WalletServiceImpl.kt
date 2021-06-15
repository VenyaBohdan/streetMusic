package com.street.micro.service.impl

import com.street.micro.entity.Wallet
import com.street.micro.repository.TransactionRepository
import com.street.micro.repository.WalletRepository
import com.street.micro.service.WalletService
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

@Component
class WalletServiceImpl(
    private val walletRepository: WalletRepository,
    private val transactionRepository: TransactionRepository
) : WalletService {

    override fun getWalletById(id: String): Wallet {
        val wallet = walletRepository.findOneById(ObjectId(id))
        wallet.transactions = transactionRepository.findAllByIdIn(wallet.transactionIds)
        return wallet
    }

    override fun getAllWallets(): List<Wallet> {
        return walletRepository.findAll();
    }

    override fun saveWallet(wallet: Wallet): Wallet {
        return walletRepository.insert(wallet)
    }

}