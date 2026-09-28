package com.accenture.ltt.collection.demo.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteratorExample {
	public static void main(String[] args) {
		ArrayList<String> empNames = new ArrayList<>();
		empNames.add("John");
		empNames.add("Riya");
		empNames.add("Ram");
		empNames.add("Ali");
		empNames.add("Jess");
		// Iterate ArrayList using Iterator
		Iterator<String> itr = empNames.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}

}
