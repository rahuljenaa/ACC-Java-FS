package com.accenture.ltt.linelength;

public class LongLineExample1 {
	public static void main(String[] args) {
		String message = "This is a very long string that is exceeding the recommended line "
				+ "length in Java and makes the code harder to read and maintain "
				+ "because you have to scroll horizontally.";
		System.out.println(message);
	}

}

//Line Length: Lines longer than 80-100 characters are split into multiple lines.

//String Concatenation: If a string is too long, you can break it into multiple strings and concatenate them using the + operator.