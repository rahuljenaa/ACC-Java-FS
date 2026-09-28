package com.accenture.ltt.exceptions.runtime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchJDK7 {
	public void division() {

		System.out.println("Enter Nr and dr");

		int q = 0;
		Scanner sc = new Scanner(System.in);
		try {

			int nr = sc.nextInt();
			int dr = sc.nextInt();

			q = nr / dr;

		} catch (ArithmeticException | InputMismatchException e) {
			e.printStackTrace();
		}
		sc.close();
		System.out.println("quotient = " + q);

	}

	public static void main(String[] args) {
		MultipleCatchJDK7 a = new MultipleCatchJDK7();
		a.division();

	}
}
