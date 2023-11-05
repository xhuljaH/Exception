package com.example.Exception.repository;

import com.example.Exception.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByCustomerNumber(String customerNumber);

    Optional<Account> findByAccountNumber(String accountNumber);
}
