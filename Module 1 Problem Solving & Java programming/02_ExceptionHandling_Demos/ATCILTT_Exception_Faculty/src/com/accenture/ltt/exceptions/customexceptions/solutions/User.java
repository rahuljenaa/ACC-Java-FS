package com.accenture.ltt.exceptions.customexceptions.solutions;

import java.util.Scanner;

public class User {
	String username = null;
	String password = null;

	public void validate() throws InvalidCredentialsException {

		if (username.equals("tom") && password.equals("tom@123")) {
			System.out.println("valid password");
		} else {
			throw new InvalidCredentialsException("username or password is invalid");
		}
	}

	public void input() {
 		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter username");
			username = sc.next();

			System.out.println("Enter password");
			password = sc.next();
		}
	}

	public static void main(String[] args) throws InvalidCredentialsException {
		User user = new User();
		user.input();
		user.validate();
	}
}
