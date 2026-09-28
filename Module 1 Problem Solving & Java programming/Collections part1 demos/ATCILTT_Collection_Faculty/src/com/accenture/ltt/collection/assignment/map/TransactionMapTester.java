package com.accenture.ltt.collection.assignment.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TransactionMapTester {

	public static void main(String[] args) {
		// Create a list to hold transaction
		List<Transaction> transactions = new ArrayList<>();
		// Add transaction objects to the list
		Transaction t1 = new Transaction("TD5678", 110095, 345678, 20000);
		transactions.add(t1);

		Transaction t2 = new Transaction("TD6764", 149352, 577321, 100000);
		transactions.add(t2);

		Transaction t3 = new Transaction("TD6785", 210995, 673567, 50000);
		transactions.add(t3);

		// Create a map to store transactionId and transaction object
		Map<String, Transaction> allTrasactions = new HashMap<>();
		transactions.forEach(x -> {
			String transactionId = x.getTransactionId();
			allTrasactions.put(transactionId, x);
		});
		// Call print method 
		TransactionService service = new TransactionService();
		service.printAllTransactions(allTrasactions, 210995);

	}
}
