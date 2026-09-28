package com.accenture.ltt.exceptions.runtime;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyClause {
	public static void division() {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int c;

		try {
			System.out.println("Enter a and b ");
			a = sc.nextInt();
			b = sc.nextInt();
			c = a / b;
			System.out.println("result = " + c);
		} catch (InputMismatchException | ArithmeticException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally block exceuted");
			sc.close();
		}
	}

	public static void main(String[] args) {
		division();
	}
}
