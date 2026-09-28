package com.accenture.ltt.exceptions;

@SuppressWarnings("serial")
public class InvalidUpdateOperationException extends Exception {
	public InvalidUpdateOperationException() {
		super("Entered CustomerId doesn't exist, Please give a valid CustomerId to Update");
	}

}
