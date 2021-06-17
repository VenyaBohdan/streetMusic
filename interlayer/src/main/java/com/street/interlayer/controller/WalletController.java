package com.street.interlayer.controller;

import com.street.interlayer.model.Account;
import com.street.interlayer.model.Wallet;
import com.street.interlayer.service.AccountService;
import com.street.interlayer.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Wallet> getWalletById(@PathVariable String id) {
        return ResponseEntity.ok(walletService.getWalletById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Wallet>> getAllWallets() {
        return ResponseEntity.ok(walletService.getAllWallets());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Wallet> saveWallet(@RequestBody Wallet wallet) {
        if (wallet != null) {
            return ResponseEntity.ok(walletService.saveWallet(wallet));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBand(@PathVariable String id) {
        walletService.deleteWallet(id);
    }

}
