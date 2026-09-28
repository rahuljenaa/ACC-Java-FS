package com.accenture.ltt.packages;

import java.util.Scanner; // Specific import, not wildcard

public class TemperatureConverter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Using built-in Java package

		System.out.print("Enter temperature in Celsius: ");
		double celsius = scanner.nextDouble();

		double fahrenheit = convertToFahrenheit(celsius);

		System.out.println("Temperature in Fahrenheit: " + fahrenheit);

		scanner.close(); // Clean code: resource management
	}

	// Clean, reusable method with a meaningful name
	private static double convertToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}
}
