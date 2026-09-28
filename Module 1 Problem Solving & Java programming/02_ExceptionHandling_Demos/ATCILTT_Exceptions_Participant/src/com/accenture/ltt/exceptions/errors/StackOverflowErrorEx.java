package com.accenture.ltt.exceptions.errors;

public class StackOverflowErrorEx {

	public static void main(String[] args) {
		//TODO 1. invoke factorial method
	}

	public static int factorial(int n) {
		return n * factorial((n - 1));
	}

}
