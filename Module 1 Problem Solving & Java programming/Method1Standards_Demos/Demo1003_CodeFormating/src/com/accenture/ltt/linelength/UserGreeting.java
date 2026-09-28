package com.accenture.ltt.linelength;

//This class demonstrates good Java code formatting and best practices.
import java.util.Scanner;

public class UserGreeting {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your first name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter your last name: ");
		String lastName = scanner.nextLine();

		// Proper spacing, line length, and indentation
		String greetingMessage = generateGreeting(firstName, lastName);

		System.out.println(greetingMessage);

		scanner.close();
	}

	// Properly indented method with consistent spacing and braces
	private static String generateGreeting(String firstName, String lastName) {
		return "Hello, " + firstName + " " + lastName + "! Welcome to the Java formatting demo.";
	}
}
