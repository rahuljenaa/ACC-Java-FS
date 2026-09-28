package com.accenture.ltt.exceptions.checked.solutions;

import java.io.FileWriter;
import java.io.IOException;

public class TryCatch {
	public static void write() {
		try {
			FileWriter fw = new FileWriter("src/files/users.txt", true);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		write();
	}
}
