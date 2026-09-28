package com.accenture.ltt.java8features;

public class DefaultMethodImpl implements IDefaultMethod {

	//Default can be overridden in the sub class
	//Comment the below print() method and try
	public void print() {
		System.out.println("Default method overridden in the implemented class");
	}
	
}
