package com.luxoft.model;

import java.sql.Timestamp;

public class Transaction {

	private Timestamp timestamp;
	private Oil oil;
	private Integer quantity;
	private TransactionType transactionType;
	private Double price;

	public Transaction(Timestamp timestamp, Oil oil, Integer quantity, TransactionType transactionType, Double price) {
		this.timestamp = timestamp;
		this.oil = oil;
		this.quantity = quantity;
		this.transactionType = transactionType;
		this.price = price;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public Oil getOil() {
		return oil;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public Double getPrice() {
		return price;
	}

}
