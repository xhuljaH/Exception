package com.example.Exception.Request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
   public class AccountRequestParam {

    private String accountNumber;

    private BigDecimal balance;

    private String customerNumber;


}