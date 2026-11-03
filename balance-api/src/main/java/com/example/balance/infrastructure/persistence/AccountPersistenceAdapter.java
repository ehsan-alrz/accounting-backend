package com.example.balance.infrastructure.persistence;

import com.example.balance.application.port.output.LoadAccountPort;
import com.example.balance.domain.model.Account;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountPersistenceAdapter implements LoadAccountPort {

    private final SpringDataAccountRepository accountRepository;

    public AccountPersistenceAdapter(SpringDataAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> loadAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .map(entity -> new Account(
                        entity.getId(),
                        entity.getAccountNumber(),
                        entity.getBalance(),
                        entity.getCurrency()
                ));
    }
}