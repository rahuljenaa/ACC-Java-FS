package com.accenture.ltt;

public class Customer {
	private String customerName;
	private Account account;
	
	public Customer(){
		account = new Account();
		account.setAccountNo(9001);
		account.setAmount(5000.0);
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Account getAccount() {
		return account;
	}		

}
