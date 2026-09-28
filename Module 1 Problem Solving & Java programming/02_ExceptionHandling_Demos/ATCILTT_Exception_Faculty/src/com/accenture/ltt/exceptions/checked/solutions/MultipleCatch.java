package com.accenture.ltt.exceptions.checked.solutions;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MultipleCatch {
	public static void write() {

		try {
			FileWriter fw = new FileWriter("d://src/files/users.txt", true);
			fw = new FileWriter("d://src/files/users.txt");
			fw.write("john@gmail.com");
			fw.flush();
		} catch (FileNotFoundException f) {
			System.out.println(f.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		write();
	}
}
