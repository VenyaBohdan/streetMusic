package com.street.micro.service

import com.street.micro.entity.Wallet
import org.springframework.stereotype.Service

@Service
interface WalletService {

    fun getWalletById(id: String): Wallet
    fun getAllWallets(): List<Wallet>
    fun saveWallet(wallet: Wallet): Wallet
    fun deleteWallet(id: String)

}