package com.accenture.ltt.exceptions.errors.solutions;

public class StackOverflowErrorEx {

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

	public static int factorial(int n) {
		return n * factorial((n - 1));
	}

}
