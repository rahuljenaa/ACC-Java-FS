package com.accenture.ltt.collection.assignment.map;

import java.util.Map;

public class TransactionService {
	// Method to print transaction ids for an account number
	public void printAllTransactions(Map<String, Transaction> transactions, long accountNumber) {
		//Check whether account number of each element in the collection is matching the provided account number
		transactions.forEach((k, v) -> {
			if (v.getSenderAccountNumber() == accountNumber) {
				//Print transaction id if a match of account number is found
				System.out.println(k);
			}
		});

	}
}
