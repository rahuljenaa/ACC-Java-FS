package com.accenture.ltt.exceptions.customexceptions;

import java.util.Scanner;

public class User {
	String username = null;
	String password = null;

	// TODO 1. if credentials are invalid, raise InvalidCredentialsException
	public void validate() {

		if (username.equals("tom") && password.equals("tom@123")) {
			System.out.println("valid");
		} else {
			// TODO create an instance of InvalidCredentialsException
			// TODO raise an exception using throw clause
			System.out.println("invalid");
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

	public static void main(String[] args) {
		User user = new User();
		user.input();
		user.validate();
	}
}
