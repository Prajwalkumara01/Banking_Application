package com.banking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByFromAccountnumber(Long accountnumber);
}
