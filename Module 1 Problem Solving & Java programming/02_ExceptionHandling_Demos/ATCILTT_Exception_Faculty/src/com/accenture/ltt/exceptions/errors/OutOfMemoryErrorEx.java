package com.accenture.ltt.exceptions.errors;

public class OutOfMemoryErrorEx {
	public static void main(String[] args) {
		int j = 1;
		while(true) {
			int i[] = new int[Integer.MAX_VALUE];
			System.out.println(j++);
		}
	}
}
