package com.accenture.ltt.exceptions.checked.solutions;

import java.io.FileWriter;
import java.io.IOException;

public class ThrowsClause {
	public static void write() throws IOException {

		try (FileWriter fw = new FileWriter("src/files/users.txt", true);) {
			fw.write("john@gmail.com");
			fw.write(System.lineSeparator());
			fw.flush();
			System.out.println("record created");
		}

	}

	public static void main(String[] args) {
		try {
			write();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
