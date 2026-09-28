package com.accenture.ltt.collection.assignment.list;

import java.util.ArrayList;
import java.util.List;


public class TransactionTester {

	public static void main(String[] args) {
		//ArrayList to store transaction objects
		List<Transaction> transactions = new ArrayList<>();
		
		//Create transaction objects and add them to the ArrayList
		Transaction t1 = new Transaction("TD5678", 110095, 345678, 20000);
		transactions.add(t1);

		Transaction t2 = new Transaction("TD6764", 149352, 577321, 100000);
		transactions.add(t2);

		Transaction t3 = new Transaction("TD6785", 210995, 673567, 50000);
		transactions.add(t3);

		//Call print method of service class which prints transactions corresponding to the account number
		TransactionService service = new TransactionService();
		service.printAllTransactions(transactions, 110095);

	}
}
