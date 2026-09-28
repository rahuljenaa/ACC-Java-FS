package com.accenture.ltt.nine;

import java.util.List;

public class Tester1011 {
	public static void main(String[] args) {
		List<Integer> list = List.of(1,2,3,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
		List<Integer> list2=list;
		
		list.add(12);
		
		if(list==list2) {
			System.out.println("From here...");
		}
		
	}

	
}
