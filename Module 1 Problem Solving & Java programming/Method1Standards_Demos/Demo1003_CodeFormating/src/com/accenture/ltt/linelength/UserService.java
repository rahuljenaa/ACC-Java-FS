package com.accenture.ltt.linelength;

public class UserService {

	// Create a new User object
	public User createUser(User user) {
		// Logic for creating a user (like saving it to a database)
		System.out.println("Creating user: " + user.getName());
		return user; // Return the user object for chaining
	}

	// Save the user to the database (or perform some operation)
	public void save(User user) {
		System.out.println(
				"Saving user: " + user.getName() + ", Address: " + user.getAddress() + ", Role: " + user.getRole());
	}
}
