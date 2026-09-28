package com.accenture.ltt.collection.demo.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
	public static void main(String[] args) {
		// Create a map to store telephone numbers of users
		Map<Integer, String> directory = new HashMap<>();
		directory.put(404232, "Venkat Rajaram");
		directory.put(502113, "Tia Mathew");
		directory.put(562190, "Ali Mohammed");
		directory.put(764342, "Fatemah Ibrahim");
		directory.put(232428, "Dennis Jacob");
		// Print Map elements
		System.out.println(directory);
	}
}