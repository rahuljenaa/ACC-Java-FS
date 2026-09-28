package com.accenture.ltt.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;


public class Employee implements InitializingBean {
	
	private String firstName;	
	private String lastName;

	public Employee() {
		System.out.println("\n\n1. constructor");
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("2. setter");
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println("4. postConstruct()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("5. afterPropertiesSet()");
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}