package com.accenture.ltt.collection.activity.set;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {
		// Create a set to store account numbers
		HashSet<Integer> accountNumbers = new HashSet<>();
		accountNumbers.add(230041988);
		accountNumbers.add(230019090);
		accountNumbers.add(230091191);
		accountNumbers.add(230187110);
		accountNumbers.add(230032498);
		//Print account numbers
		System.out.println(accountNumbers);
	}
}