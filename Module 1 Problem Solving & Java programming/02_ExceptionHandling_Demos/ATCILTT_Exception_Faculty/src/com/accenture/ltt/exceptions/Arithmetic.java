package com.accenture.ltt.exceptions;

import java.util.Scanner;

public class Arithmetic {

	public void division(byte nr, byte dr) {
		if (dr == 0) {
			System.out.println("Cannot divide by zero");
		}   else {
			System.out.println("Qutoient = " + nr / dr);
		}
	}

	public static void main(String[] args) {
		Arithmetic a = new Arithmetic();
		Scanner sc = new Scanner(System.in);
		char ch = 0;
		do {

			System.out.println("Enter Numerator [-128 to 127]");
			byte nr = sc.nextByte();

			System.out.println("Enter Dr [-128 to 127]");
			byte dr = sc.nextByte();
			a.division(nr, dr);

			System.out.print("Enter [ Y ] to continue OR --> any key to exit\n");
			ch = sc.next().charAt(0);
			System.out.println("***********************************");

		} while (ch == 'y' || ch == 'Y');
	}

}
