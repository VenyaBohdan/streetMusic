package com.street.interlayer.service;

import com.street.interlayer.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Account getAccountById(Long id);

}
