package com.accenture.ltt.collection.assignment.list;

import java.util.List;
import java.util.stream.Collectors;


public class TransactionService {
	
	//Method which helps print transactions corresponding to a particular account

	public void printAllTransactions(List<Transaction> transactions, long accountNumber) {
		//Create a stream on the collection which contains all transaction objects.
		//Use a Filter funtional interface to filter transactions corresponding to the account number.
		List<Transaction> list = transactions.stream().filter(x -> x.getSenderAccountNumber() == accountNumber)
				.collect(Collectors.toList());
		System.out.println(list);
	}
}
