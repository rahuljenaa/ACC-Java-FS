package com.accenture.ltt.linelength;

public class TestUtil {

	public static void main(String[] args) {
		// Create a UserService object
		UserService userService = new UserService();

		// Create a user, set their address, assign a role, and save the user
		User user = new User("John Doe");

		// Using method chaining to create, set address, set role, and save
		userService.createUser(user) // Create the user
				.setAddress("1234 Elm Street") // Set the address
				.setRole("Admin"); // Set the role

		// Now save the user
		userService.save(user); // Save the user after all properties have been set
	}
}
