package com.accenture.ltt.collection.demo.set;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {
		// Create a set to store user ids
		HashSet<String> userIds = new HashSet<>();
		userIds.add("John1988");
		userIds.add("Riya1990");
		userIds.add("Ram1991");
		userIds.add("Ali1990");
		userIds.add("Jess1987");
		System.out.println(userIds);
	}
}