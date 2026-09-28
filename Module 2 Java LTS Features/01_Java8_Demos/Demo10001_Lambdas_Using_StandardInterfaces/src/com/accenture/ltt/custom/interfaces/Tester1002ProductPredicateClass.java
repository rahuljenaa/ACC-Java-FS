package com.accenture.ltt.custom.interfaces;

import com.accenture.ltt.a.pojo.Product;

interface ProductPredicateInterface {
	boolean productCategory(String name);
}
public class Tester1002ProductPredicateClass {
	
	public static void main(String[] args) {
		// Product 
		ProductPredicateInterface ppi = (name) -> new Product().productCategory(name);
		System.out.println("Is product electronics category? " + ppi.productCategory("electronics"));
	}

}
