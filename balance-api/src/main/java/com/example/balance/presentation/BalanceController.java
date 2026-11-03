package com.example.balance.presentation;

import com.example.balance.application.port.input.GetBalanceUseCase;
import com.example.balance.domain.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/balances")
public class BalanceController {

    private final GetBalanceUseCase getBalanceUseCase;

    public BalanceController(GetBalanceUseCase getBalanceUseCase) {
        this.getBalanceUseCase = getBalanceUseCase;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getBalance(@PathVariable Long accountId) {
        Account account = getBalanceUseCase.getBalance(accountId);
        return ResponseEntity.ok(account);
    }
}