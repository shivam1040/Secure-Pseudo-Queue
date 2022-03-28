package com.example.securepseudoqueuereceiver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonProperty("Account Number")
	private String accountNumber;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Amount")
	private String amount;
	@JsonProperty("Currency")
	private String currency;
	@JsonProperty("AccountFrom")
	private String accountFrom;
	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", accountNumber=" + accountNumber + ", type=" + type + ", amount="
				+ amount + ", currency=" + currency + ", accountFrom=" + accountFrom + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	public TransactionEntity(Long id, String accountNumber, String type, String amount, String currency,
			String accountFrom) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.type = type;
		this.amount = amount;
		this.currency = currency;
		this.accountFrom = accountFrom;
	}
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
