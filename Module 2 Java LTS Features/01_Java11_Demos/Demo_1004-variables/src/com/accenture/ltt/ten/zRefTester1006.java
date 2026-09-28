package com.accenture.ltt.ten;

public class zRefTester1006 {
	public static void main(String[] args) {
		var obj = new Object() {}; // child class of object
		
		obj = new Object();    // cannot point back to parent as data type is inffered in the previous step
		
		
	}	

}
//Proof of static typing