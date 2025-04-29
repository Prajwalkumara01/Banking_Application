package com.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
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
	
	public Transaction( Long fromAccountnumber, Long toAccountnumber, Double amount) {
		super();
		this.fromAccountnumber = fromAccountnumber;
		this.toAccountnumber = toAccountnumber;
		this.amount = amount;
	}
	public Transaction() {
		super();
	}

    
}
