package com.accenture.ltt.packages;

//Good import practice: only import what's needed
//import java.util.Scanner;// Regular/default import
import java.util.*;
public class UserGreeting {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Using built-in Java package (java.util)

		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

		greetUser(name);

		scanner.close(); // Clean code: closing resources
	}

	// Clean code: meaningful method name and proper documentation
	private static void greetUser(String name) {
		if (name != null && !name.trim().isEmpty()) {
			System.out.println("Hello, " + name + "!");
		} else {
			System.out.println("Hello, guest!");
		}
	}
}
