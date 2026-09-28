package com.accenture.ltt.custom.interfaces;

import com.accenture.ltt.a.pojo.Product;

interface ProductSupplierInterface {
	String returnName();
}

public class Tester1003ProductSupplierClass {
	public static void main(String[] args) {
		ProductSupplierInterface msiProduct = () -> new Product().returnProductName();
		System.out.println(msiProduct.returnName());
		
	}

}
