package com.accenture.ltt.exceptions.runtime;

import java.util.Scanner;

public class TryCatch {

	public static void input() {
		// enter index = 6 when prompted
		// observe the error
		// TODO 1. handle IndexOutOfBoundsException using catch clause

		int numbers[] = { 10, 20, 30, 40, 50 };
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter index to [1 - 6] to find the element stored at that index");
		int index = sc.nextInt();

		System.out.println(numbers[index]);

	}

	public static void main(String[] args) {
		input();
	}
}
