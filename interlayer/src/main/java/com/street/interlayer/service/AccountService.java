package com.street.interlayer.service;

import com.street.interlayer.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Account getAccountById(Long id);
    List<Account> getAllAccounts();
    Account saveAccount(Account account);
    void deleteAccount(Long id);

}
