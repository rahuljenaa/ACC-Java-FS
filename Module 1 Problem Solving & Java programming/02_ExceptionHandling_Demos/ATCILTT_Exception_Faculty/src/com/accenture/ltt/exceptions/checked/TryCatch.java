package com.accenture.ltt.exceptions.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TryCatch {
	public static void read() {
		try {
			FileReader fr = new FileReader("src/files/welcome.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		read();
	}
}
