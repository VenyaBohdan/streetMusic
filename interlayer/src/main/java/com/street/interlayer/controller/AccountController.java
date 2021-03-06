package com.street.interlayer.controller;

import com.street.interlayer.model.Account;
import com.street.interlayer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getAccountById(Long.valueOf(id)));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        if (account != null) {
            return ResponseEntity.ok(accountService.saveAccount(account));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBand(@PathVariable String id) {
        accountService.deleteAccount(Long.valueOf(id));
    }

}
