package com.accenture.ltt.exceptions.runtime;

import java.util.Scanner;

 
public class TryCatch {
 
	public void division(byte nr, byte dr) {
		try {
			System.out.println("Quotient = " + nr/dr);
		}catch(ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
	}

	public static void main(String[] args) {
 		TryCatch a = new TryCatch();
		Scanner sc = new Scanner(System.in);
		char ch;
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
		sc.close();
	}

}
