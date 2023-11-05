package com.example.Exception.service;

import com.example.Exception.Request.AccountRequestParam;
import com.example.Exception.exception.AccountBalanceZeroExeption;
import com.example.Exception.exception.AccountNotFoundException;
import com.example.Exception.model.Account;
import com.example.Exception.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> retrieveAllByCustomerNumber(String customerNumber) {
        return accountRepository.findAllByCustomerNumber(customerNumber);
    }

    public Account retrieveAccountByAccountNumber(String accountNumber) {
        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber);

        if (optionalAccount.isEmpty()) {
            throw new AccountNotFoundException("Account with account number "
                    + accountNumber + " does not exist.");
        }
        return optionalAccount.get();
    }

    public Account createAccount(AccountRequestParam accountRequestParam) {
        if (accountRequestParam.getBalance().compareTo(BigDecimal.ZERO) == 0) {
            throw new AccountBalanceZeroExeption("Account balance is less than required");
        }
        Account account = new Account();
        account.setAccountNumber(accountRequestParam.getAccountNumber());
        account.setBalance(accountRequestParam.getBalance());
        account.setCustomerNumber(accountRequestParam.getCustomerNumber());

        return accountRepository.save(account);
    }

}