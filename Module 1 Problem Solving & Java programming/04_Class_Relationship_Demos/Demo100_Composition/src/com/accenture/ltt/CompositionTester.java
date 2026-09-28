package com.accenture.ltt;

public class CompositionTester {

	public static void main(String[] args) {
		Customer customer = new Customer();

		customer.setCustomerName("John");

		System.out.println("Account details are:");
		System.out.println("Customer Name: " + customer.getCustomerName());
		System.out.println("Account Number: " + customer.getAccount().getAccountNo()); // Pay attention and try to
																						// understand this code
		System.out.println("Balance Amount: " + customer.getAccount().getAmount()); // Pay attention and try to
																					// understand this code
	}

}
