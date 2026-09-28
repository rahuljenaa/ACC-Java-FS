package com.accenture.ltt.service;

import com.accenture.ltt.busisnessbean.Employee;
import com.accenture.ltt.exceptions.InvalidEmailAddressException;

public class EmployeeService {

	public int computeSalary(Employee employee, int taxRate) {
		int finalSalary = 0;
		try {
			int salary = employee.getSalary();
			int taxOnSalary = salary / taxRate;
			finalSalary = salary - taxOnSalary;
		} catch (ArithmeticException | NullPointerException exception) {
			throw exception;
		}
		return finalSalary;
	}

	public int incrementSalary(Employee employee, int increment) {
		int newSalary = 0;
		try {
			newSalary = employee.getSalary() + increment;
		} catch (NullPointerException exception) {
			throw exception;
		}
		return newSalary;
	}
	
	public void validateEmailAddress(Employee employee) throws InvalidEmailAddressException{
		String email = employee.getEmail();
		if (! email.contains("@")) {
			throw new InvalidEmailAddressException("Employee's Email Address is invalid");
		} 
		System.out.println(email);
	}
	
	public void getEmployeeDetails() {
		System.out.println("Fetching details ...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
