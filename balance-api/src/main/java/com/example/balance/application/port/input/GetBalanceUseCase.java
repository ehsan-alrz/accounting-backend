package com.example.balance.application.port.input;

import com.example.balance.domain.model.Account;

public interface GetBalanceUseCase {
    Account getBalance(Long accountId);
}