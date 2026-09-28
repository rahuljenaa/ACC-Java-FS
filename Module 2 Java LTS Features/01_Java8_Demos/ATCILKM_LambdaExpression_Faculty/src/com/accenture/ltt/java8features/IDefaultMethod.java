package com.accenture.ltt.java8features;

public interface IDefaultMethod {
	public default void print() {
		System.out.println("Default Method !!");
	}

}
