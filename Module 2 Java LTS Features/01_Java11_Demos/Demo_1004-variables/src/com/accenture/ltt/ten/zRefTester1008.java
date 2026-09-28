package com.accenture.ltt.ten;

import java.util.List;

public class zRefTester1008 {
	public static void main(String[] args) {
		var list = List.of(1, 2.0, "3"); //Used to give error in java 10
		list.forEach(v-> System.out.println(v));
		
	}

}
