package com.accenture.ltt.zeleven;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Tester1001 {
	public static void main(String[] args) {
		var  v = Arrays.asList("James","Dan","Eric","Stuart","Mario","Cynthya","Lucy");
		var list= v.stream().filter(name->name.contains("a")).collect(Collectors.toList());
		list.forEach(System.out::print);

	}

}
// Run as Script Program
/**
 *
 * C:\Program Files\Java\jdk-11.0.4\bin>java zeleven/Tester1001.java
 * There is a demo placed in jdk under zeleven.
 **/
