package com.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fromAccountnumber;
    private Long toAccountnumber;
    private Double amount;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
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
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
	public Transaction( Long fromAccountnumber, Long toAccountnumber, Double amount) {
		super();
//		this.id = id;
		this.fromAccountnumber = fromAccountnumber;
		this.toAccountnumber = toAccountnumber;
		this.amount = amount;
//		this.type = type;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and Setters
    
}
