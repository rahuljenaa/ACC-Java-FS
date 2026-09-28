package com.accenture.ltt.linelength;

public class User {

	private String name;
	private String address;
	private String role;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getRole() {
		return role;
	}

	// Setters for method chaining
	public User setAddress(String address) {
		this.address = address;
		return this; // Return the current object (this) for chaining
	}

	public User setRole(String role) {
		this.role = role;
		return this; // Return the current object (this) for chaining
	}
}
