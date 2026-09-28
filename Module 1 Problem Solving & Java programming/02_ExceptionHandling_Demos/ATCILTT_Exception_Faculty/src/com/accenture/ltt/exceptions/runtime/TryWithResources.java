package com.accenture.ltt.exceptions.runtime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryWithResources {

	public void division() {
		System.out.println("Enter Nr and dr");

		int q = 0;
		try (Scanner sc = new Scanner(System.in);) {

			int nr = sc.nextInt();
			int dr = sc.nextInt();

			q = nr / dr;

		} catch (ArithmeticException | InputMismatchException e) {
			e.printStackTrace();
		}

		System.out.println("quotient = " + q);

	}

	public static void main(String[] args) {
		TryWithResources a = new TryWithResources();
		a.division();

	}
}
