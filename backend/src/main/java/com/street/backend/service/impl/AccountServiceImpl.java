package com.street.backend.service.impl;

import com.street.backend.entity.Account;
import com.street.backend.entity.Admin;
import com.street.backend.repository.AccountRepository;
import com.street.backend.repository.AdminRepository;
import com.street.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        Admin admin = new Admin();
        admin.setAccount(account);
        Admin savedAdmin = adminRepository.save(admin);
        savedAccount.setAdmin(savedAdmin);
        return savedAccount;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}
