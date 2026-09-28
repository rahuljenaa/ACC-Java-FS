package com.accenture.ltt.exceptions.runtime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryWithResources {

	public static void input() {
		// TODO 1.create an instance of Scanner using try-with-resource statement
		// TODO 2. remove finally clause
		int numbers[] = { 10, 20, 30, 40, 50 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index to [1 - 6] to find the element stored at that index");
		try {
			int index = sc.nextInt();
			System.out.println(numbers[index]);
		} catch (IndexOutOfBoundsException | InputMismatchException e) {
			throw e;
		} finally {
			sc.close();
		}
	}

	public static void main(String[] args) {
		input();
	}

}
