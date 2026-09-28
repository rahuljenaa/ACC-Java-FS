package com.accenture.ltt.zeleven;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Not Predicate...
public class Tester1002_Not_Predicate {
	public static void main(String[] args) {
		List<String> list =  List.of("Jack","Jim","James","Tim","Dan","Eric");
	 	List<String>filteredList= list.stream().filter(Predicate.not(x->x.length()>=4)).collect(Collectors.toList());
	 	System.out.println(filteredList);
	}

}
