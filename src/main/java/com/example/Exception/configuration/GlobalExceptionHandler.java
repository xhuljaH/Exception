package com.example.Exception.configuration;

import com.example.Exception.exception.AccountBalanceZeroExeption;
import com.example.Exception.exception.AccountNotFoundException;
import com.example.Exception.model.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ErrorResponse handleAccountNotFound(AccountNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(0);

        errorResponse.setMessage(e.getMessage());
        return errorResponse;

    }

    @ExceptionHandler(value = {AccountBalanceZeroExeption.class})
    public ErrorResponse handleAccountNotFound(AccountBalanceZeroExeption e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(0);

        errorResponse.setMessage(e.getMessage());
        return errorResponse;

    }

    @ExceptionHandler(value = {Exception.class})
    public ErrorResponse handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(0);
        errorResponse.setMessage("Sorry something went wrong.");

        return errorResponse;

    }
}
