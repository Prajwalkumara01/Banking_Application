package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.service.AccountService;

@RestController
@RequestMapping("/api")

public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/balance/{useraccountnumber}")
    public Double getBalance(@PathVariable Long useraccountnumber) {
        return accountService.getBalance(useraccountnumber);
    }

    @GetMapping("/transactions/{accountnumber}")
    public List<Transaction> getTransactions(@PathVariable Long accountnumber) {
        return accountService.getTransactions(accountnumber);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest transferRequest) {
        accountService.transferMoney(
        	
            transferRequest.getFromAccountnumber(),
            transferRequest.getToAccountnumber(),
            transferRequest.getAmount()
        );
        return "Transfer successful";
    }
}

class TransferRequest {
    private Long fromAccountnumber;
    private Long toAccountnumber;
    private Double amount;
    
	public Long getFromAccountnumber() {
		return fromAccountnumber;
	}
	public void setFromAccountnumber(Long fromAccountnumber) {
		this.fromAccountnumber = fromAccountnumber;
	}
	public Long getToAccountnumber() {
		return toAccountnumber;
	}
	public void setToAccountnumber(Long toAccountnumber) {
		this.toAccountnumber = toAccountnumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public TransferRequest(Long fromAccountnumber, Long toAccountnumber, Double amount) {
		super();
		this.fromAccountnumber = fromAccountnumber;
		this.toAccountnumber = toAccountnumber;
		this.amount = amount;
	}
	public TransferRequest() {
		super();
	}
    
}
