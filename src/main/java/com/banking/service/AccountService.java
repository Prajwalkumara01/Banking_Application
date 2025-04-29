package com.banking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.repository.AccountRepository;
import com.banking.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Double getBalance(Long useraccountnumber) {
        Account account = accountRepository.findByUseraccountnumber(useraccountnumber);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        return account.getBalance();
    }

    public List<Transaction> getTransactions(Long accountnumber) {
        return transactionRepository.findByFromAccountnumber(accountnumber);
    }

    @Transactional
    public void transferMoney(Long fromAccountnumber, Long toAccountnumber, Double amount) {
        Account from = accountRepository.findByUseraccountnumber(fromAccountnumber);
        Account to = accountRepository.findByUseraccountnumber(toAccountnumber);

        if (from == null) {
            throw new RuntimeException("From Account not found");
        }
        if (to == null) {
            throw new RuntimeException("To Account not found");
        }

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepository.save(from);
        accountRepository.save(to);

        // ✅ Save Transaction History
        Transaction transaction = new Transaction();
        transaction.setFromAccountnumber(fromAccountnumber);
        transaction.setToAccountnumber(toAccountnumber);
        transaction.setAmount(amount);

        transactionRepository.save(transaction);
    }

}
