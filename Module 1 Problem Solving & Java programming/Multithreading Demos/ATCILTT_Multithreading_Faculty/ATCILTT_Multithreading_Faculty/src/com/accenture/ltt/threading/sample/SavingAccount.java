package com.accenture.ltt.threading.sample;

public class SavingAccount {

	// instance variable
	float balance = 1000f;

	// method to withdraw the amount from Saving Account
	//Note - Add synchronization in method signature to show the example of synchronization
	public void withdraw(float amount) {
		if (amount > 0 && amount <= balance) {
			balance = balance - amount;
		}
	}

	// method to deposit the amount into Saving Account
	//Note - Add synchronization in method signature to show the example of synchronization
	public void deposit(float amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Can not withdaw negative amount");
		}
		balance = balance + amount;

	}
}
