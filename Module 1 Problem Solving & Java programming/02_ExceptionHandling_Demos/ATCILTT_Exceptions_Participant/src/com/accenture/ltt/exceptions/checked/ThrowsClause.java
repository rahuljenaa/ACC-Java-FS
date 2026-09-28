package com.accenture.ltt.exceptions.checked;

import java.io.FileWriter;
import java.io.IOException;

public class ThrowsClause {
	// TODO 1. remove try and catch clause from write method
	// TODO 2. declare IOException on write() method using throws clause
	
	public static void write(String username, String password) {
		try (FileWriter fw = new FileWriter("src/files/users.txt", true);) {
			fw.write(username + "," + password);
			fw.write(System.lineSeparator());
			fw.flush();
			System.out.println("record created");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
 
	public static void main(String[] args) {
		write("john", "john@123");
	}
}
