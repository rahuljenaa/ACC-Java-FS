package com.accenture.ltt;

public class IndentationExample {
	// This is the main method
	public static void main(String[] args) {
		int number = 10;
		// Conditional block with correct indentation
		if (number > 5) {
			System.out.println("Number is greater than 5");
			// Nested if statement
			if (number == 10) {
				System.out.println("Number is 10");
			}
			} else {
				System.out.println("Number is 5 or less");
				}
		}
}
//The code inside the if and else blocks is indented with 4 spaces.
//The code inside the nested if block is indented further with 4 more spaces.
