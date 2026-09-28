package com.accenture.ltt.exceptions.runtime.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchJDK7 {
	public static void input() {

		int numbers[] = { 10, 20, 30, 40, 50 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index to [1 - 6] to find the element stored at that index");
		try {
			int index = sc.nextInt();
			System.out.println(numbers[index]);
		} catch (InputMismatchException | IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	public static void main(String[] args) {
		input();
	}

}
