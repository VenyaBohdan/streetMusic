package com.street.backend.service;

import com.street.backend.entity.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {

    Optional<Account> getAccountById(Long id);
    Iterable<Account> getAllAccounts();
    Account saveAccount(Account account);
    void deleteAccount(Long id);

}
