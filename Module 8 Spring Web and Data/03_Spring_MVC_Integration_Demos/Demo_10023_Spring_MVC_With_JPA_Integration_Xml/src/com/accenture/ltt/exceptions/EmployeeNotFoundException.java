package com.accenture.ltt.exceptions;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 6593948648162426526L;

	public EmployeeNotFoundException() {
		super("Entered EmployeeId doesn't exist, Please give a valid employeeId");
	}
}
