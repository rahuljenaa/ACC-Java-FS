package com.accenture.ltt.exceptions.runtime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MutipleCatch {
	public void division() {

		System.out.println("Enter Nr and dr");

		int q = 0;
		Scanner sc = new Scanner(System.in);
		try {
			int nr = sc.nextInt();
			int dr = sc.nextInt();

			q = nr / dr;

		} catch (InputMismatchException i) {
			i.printStackTrace();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		sc.close();
		System.out.println("quotient = " + q);

	}

	public static void main(String[] args) {
		MutipleCatch a = new MutipleCatch();
		a.division();

	}
}
