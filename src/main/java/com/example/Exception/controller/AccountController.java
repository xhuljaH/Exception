package com.example.Exception.controller;

import com.example.Exception.Request.AccountRequestParam;
import com.example.Exception.exception.AccountNotFoundException;
import com.example.Exception.model.Account;
import com.example.Exception.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public List<Account> retrieveAllByCustomerNumber(@RequestParam String customerNumber) {
        return accountService.retrieveAllByCustomerNumber(customerNumber);
    }

    @GetMapping("/{customerNumber}")
    public Account retrieveAccountByAccountNumber(@PathVariable String customerNumber) throws AccountNotFoundException {
        return accountService.retrieveAccountByAccountNumber(customerNumber);
    }
    @GetMapping("/create")
    public Account createAccount(@RequestBody AccountRequestParam account) {
        return accountService.createAccount(account);
    }

}

