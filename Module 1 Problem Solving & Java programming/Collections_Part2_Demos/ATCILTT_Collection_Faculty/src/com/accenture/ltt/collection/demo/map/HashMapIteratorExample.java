package com.accenture.ltt.collection.demo.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapIteratorExample {
	public static void main(String[] args) {
		// Create a map to store telephone numbers of users
		Map<Integer, String> directory = new HashMap<>();
		directory.put(404232, "Venkat Rajaram");
		directory.put(502113, "Tia Mathew");
		directory.put(562190, "Ali Mohammed");
		directory.put(764342, "Fatemah Ibrahim");
		directory.put(232428, "Dennis Jacob");
		// Get all keys into a Set
		Set<Integer> keys = directory.keySet();
		// Create an Iterator on keySet
		Iterator<Integer> itr = keys.iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			String value = directory.get(key);
			System.out.println("Name is " + value + " Contact is " + key);
		}
	}
}