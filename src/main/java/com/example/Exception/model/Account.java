package com.example.Exception.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Table(name = "Accounts")
@Entity
@Data
public class Account  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "BALANCE")
    private BigDecimal balance;

    @Column(name = "CUSTOMER_NUMBER")
    private String customerNumber;


}
