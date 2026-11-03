package com.example.balance.application.service;

import com.example.balance.application.port.input.GetBalanceUseCase;
import com.example.balance.application.port.output.LoadAccountPort;
import com.example.balance.domain.exception.AccountNotFoundException;
import com.example.balance.domain.model.Account;
import org.springframework.stereotype.Service;

@Service
public class GetBalanceService implements GetBalanceUseCase {

    private final LoadAccountPort loadAccountPort;

    public GetBalanceService(LoadAccountPort loadAccountPort) {
        this.loadAccountPort = loadAccountPort;
    }

    @Override
    public Account getBalance(Long accountId) {
        return loadAccountPort.loadAccount(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + accountId));
    }
}