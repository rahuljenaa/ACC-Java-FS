package com.accenture.ltt.exceptions.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultipleCatch {
	public static void read() {
		try {
			FileReader fr = new FileReader("src/files/users.txt");
			int ch;
			while ((ch = fr.read()) != -1) {
				System.out.print((char) ch);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		read();
	}

}
