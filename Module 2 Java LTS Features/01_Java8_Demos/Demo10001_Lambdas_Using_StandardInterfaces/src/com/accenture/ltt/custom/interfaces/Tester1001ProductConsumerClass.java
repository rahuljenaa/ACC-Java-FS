package com.accenture.ltt.custom.interfaces;

import com.accenture.ltt.a.pojo.Product;

interface ProductConsumerInterface {
	
	void printNameInUpper(String name);

}
public class Tester1001ProductConsumerClass {
	
	public static void main(String[] args) {
		// Product 
		ProductConsumerInterface pciProduct = (name) -> new Product().printProductNameUpper(name);
		pciProduct.printNameInUpper("samsung");
		
	}

}
