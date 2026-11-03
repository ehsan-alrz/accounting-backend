package com.example.balance.application.port.output;

import com.example.balance.domain.model.Account;
import java.util.Optional;

public interface LoadAccountPort {
    Optional<Account> loadAccount(Long accountId);
}