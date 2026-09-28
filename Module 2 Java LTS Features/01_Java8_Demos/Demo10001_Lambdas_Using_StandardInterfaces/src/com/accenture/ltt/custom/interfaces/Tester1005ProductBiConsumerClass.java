package com.accenture.ltt.custom.interfaces;

import com.accenture.ltt.a.pojo.Product;

interface ProductBiConsumerInterface {
	void printDetails(int id, String name);
}

public class Tester1005ProductBiConsumerClass {
	
	public static void main(String[] args) {
		// Product 
		ProductBiConsumerInterface pbci = (id, name) -> new Product().printProductDetails(id, name);
		pbci.printDetails(111,"SONY");
		
	}

}
