package com.accenture.ltt.zeleven;

import java.util.stream.Collectors;

public class Tester1004_String_Functions {
	public static void main(String[] args) throws Exception {

		String str = "This  Lines Demo.\n Done by MSD\n new feature";
		System.out.println(str);
		var listString=str.lines().collect(Collectors.toList());
		System.out.println("List of values: "+listString);
	}

}
//Lines to split with respect to \n