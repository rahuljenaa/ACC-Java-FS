package com.accenture.ltt.exceptions;

public class InvalidEmailAddressException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidEmailAddressException(String message) {
		super(message);
	}
}
