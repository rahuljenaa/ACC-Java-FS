package com.accenture.ltt.packages;

import static java.lang.Math.*; // Static import of all static members of Math class

public class StaticImportExample {
	public static void main(String[] args) {
		// We can directly call sqrt() without Math.
		double result = sqrt(16);
		System.out.println("Square root of 16: " + result);

		// Other static methods/constants can also be used directly
		System.out.println("Value of PI: " + PI);
	}
}
