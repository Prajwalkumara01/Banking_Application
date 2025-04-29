package com.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id

    private Long userId;
    private Long useraccountnumber;   
    private Double balance;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUseraccountnumber() {
		return useraccountnumber;
	}
	public void setUseraccountnumber(Long useraccountnumber) {
		this.useraccountnumber = useraccountnumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Account(Long userId, Long useraccountnumber, Double balance) {
		super();
		this.userId = userId;
		this.useraccountnumber = useraccountnumber;
		this.balance = balance;
	}
	public Account() {
		super();
	}

    
    
}