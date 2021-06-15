package com.street.micro.controller

import com.street.micro.entity.Wallet
import com.street.micro.repository.WalletRepository
import com.street.micro.service.WalletService
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/wallet")
class WalletController(
    private val walletService: WalletService
) {
    @GetMapping
    fun getAllWallets(): ResponseEntity<List<Wallet>> {
        val wallets = walletService.getAllWallets()
        return ResponseEntity.ok(wallets)
    }

    @GetMapping("/{id}")
    fun getWalletById(@PathVariable("id") id: String): ResponseEntity<Wallet> {
        val wallet = walletService.getWalletById(id)
        return ResponseEntity.ok(wallet)
    }

    @PostMapping
    fun saveWallet(@RequestBody wallet: Wallet): Wallet {
        return walletService.saveWallet(wallet)
    }

    @DeleteMapping("/{id}")
    fun deleteWallet(@PathVariable id: String) {
        walletService.deleteWallet(id)
    }
}