package com.accenture.ltt.exceptions.runtime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowClause {
	public static void input() {
		// TODO re-throw the exception in catch block
		int numbers[] = { 10, 20, 30, 40, 50 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index to [1 - 6] to find the element stored at that index");
		try {
			int index = sc.nextInt();
			System.out.println(numbers[index]);
		} catch (InputMismatchException | IndexOutOfBoundsException e) {
			// rethrow the exception using throw clause
		}
	}

	public static void main(String[] args) {
		input();
	}
}
