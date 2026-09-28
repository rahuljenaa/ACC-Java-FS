package com.accenture.ltt.zeleven;

public class Tester1003_String_isBlank {
	
	public static void main(String[] args) {
        System.out.println(" ".isBlank()); //true
        
        String s = "MSD";
        System.out.println(s.isBlank()); //false
        String s1 = "";
        System.out.println(s1.isBlank()); //true
		
	}
	

}
///https://www.journaldev.com/24601/java-11-features#java-string-methods