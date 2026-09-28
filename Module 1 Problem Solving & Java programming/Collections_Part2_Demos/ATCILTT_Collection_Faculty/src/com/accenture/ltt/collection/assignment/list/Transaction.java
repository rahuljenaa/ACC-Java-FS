package com.accenture.ltt.collection.assignment.list;

public class Transaction {

	private String transactionId;
	private long senderAccountNumber;
	private long recipientAccountNumber;
	private long transactionAmount;

	public Transaction(String transactionId, long senderAccountNumber, long recipientAccountNumber,
			long transactionAmount) {
		this.transactionId = transactionId;
		this.senderAccountNumber = senderAccountNumber;
		this.recipientAccountNumber = recipientAccountNumber;
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public long getRecipientAccountNumber() {
		return recipientAccountNumber;
	}

	public long getTransactionAmount() {
		return transactionAmount;
	}

	@Override
	public String toString() {
		return "\n senderAccountNumber=" + senderAccountNumber + "\n recipientAccountNumber=" + recipientAccountNumber
				+ "\n transactionAmount=" + transactionAmount + "]";
	}

}
