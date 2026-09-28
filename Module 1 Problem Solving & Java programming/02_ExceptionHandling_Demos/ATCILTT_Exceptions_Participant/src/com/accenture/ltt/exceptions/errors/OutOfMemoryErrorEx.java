package com.accenture.ltt.exceptions.errors;

import java.util.Calendar;
import java.util.Date;

public class OutOfMemoryErrorEx {
	public static void main(String[] args) {
		Employee e[] = new Employee[5];

		// TODO 1. create 5 employee objects using for-loop
		// TODO 2. print emp object
	}

}

class Employee {
	int id;
	String name;
	String lname;
	String password;
	String email;
	Date dob;
	String skills[] = { "Java", "C", "C++", "C#", "Python", "SQL" };
	Address address = null;

	public Employee() {
		this(100, "John", "Michael", "secret", "john@gmail.com", Calendar.getInstance().getTime());
		address = new Address();
	}

	public Employee(int id, String name, String lname, String password, String email, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lname=" + lname + ", password=" + password + ", email="
				+ email + ", dob=" + dob + "]";
	}

}

class Address {
	String city;
	String state;
	String country;
	int x[] = new int[99999999];

	public Address() {
		this("Hyderabad", "Telangana", "Country");
	}

	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}

}