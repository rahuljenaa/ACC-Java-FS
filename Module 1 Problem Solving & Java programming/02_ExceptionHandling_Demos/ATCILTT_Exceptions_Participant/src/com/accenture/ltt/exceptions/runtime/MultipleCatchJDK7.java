package com.accenture.ltt.exceptions.runtime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchJDK7 {
	public static void input() {
		// TODO 1. write InputMismatchException and IndexOutOfBoundsException in one
		// catch handler using pipe character
		int numbers[] = { 10, 20, 30, 40, 50 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index to [1 - 6] to find the element stored at that index");
		try {
			int index = sc.nextInt();
			System.out.println(numbers[index]);
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException iob) {
			iob.printStackTrace();
		}
	}

	public static void main(String[] args) {
		input();
	}

}
