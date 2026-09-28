package com.accenture.ltt.exceptions.checked;

import java.io.FileReader;
import java.io.IOException;

public class ThrowsClause {

	public static void read() throws IOException {
		try (FileReader fr = new FileReader("src/files/users.txt");) {
			int ch;
			while ((ch = fr.read()) != -1) {
				System.out.print((char) ch);
			}
		}
	}

	public static void main(String[] args) {
		try {
			ThrowsClause.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
