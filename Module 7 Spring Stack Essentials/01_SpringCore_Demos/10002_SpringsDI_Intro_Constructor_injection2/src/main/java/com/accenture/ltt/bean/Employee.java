package com.accenture.ltt.bean;

public class Employee {
	Address primaryAddress;
	Contact primaryContact;

	public Employee(Address primaryAddress, Contact primaryContact) {
		super();
		this.primaryAddress = primaryAddress;
		this.primaryContact = primaryContact;
	}

	@Override
	public String toString() {
		return "Employee [primaryAddress=" + primaryAddress + ", primaryContact=" + primaryContact + "]";
	}

}
