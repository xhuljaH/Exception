package com.example.Exception.exception;

public class AccountBalanceZeroExeption extends RuntimeException {
    public AccountBalanceZeroExeption(String message){
        super (message);
    }

}
