package com.hcmue.shop.model;

public class TransactionModel {
	
	private int id;
	private double amount;
	private String purpose;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public TransactionModel(int id, double amount, String purpose) {
		super();
		this.id = id;
		this.amount = amount;
		this.purpose = purpose;
	}
	public TransactionModel() {
		id = 1;
	}
	@Override
	public String toString() {
		return "TransactionModel [id=" + id + ", amount=" + amount + ", purpose=" + purpose + "]";
	}
	
	
}
