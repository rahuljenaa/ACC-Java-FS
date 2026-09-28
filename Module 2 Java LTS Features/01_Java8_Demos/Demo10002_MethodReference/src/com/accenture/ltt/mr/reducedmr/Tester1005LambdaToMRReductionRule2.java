package com.accenture.ltt.mr.reducedmr;

import com.accenture.ltt.Customer;
import com.accenture.ltt.Product;
import com.accenture.ltt.a.interfaces.OneParameterCustomerObjectInterface;
import com.accenture.ltt.a.interfaces.OneParameterProductObjectInterface;
import com.accenture.ltt.a.interfaces.TwoParameterCustomerObjectInterface;
import com.accenture.ltt.a.interfaces.TwoParameterProductObjectInterface;

// Rule 2 Reduction: before arrow and after arrow signature are different and after arrow it invokes the method 
// using the object passed as parameter
public class Tester1005LambdaToMRReductionRule2 {

	public static void req1() {
		// write the LE for the methods which take 1 parameter and does not return anything
		// Product
		OneParameterProductObjectInterface printProduct = (product, name) -> product.printNameUpper(name);
		printProduct.printNameInUpperCase(new Product(), "samsung");

		OneParameterProductObjectInterface printProduct2 = Product::printNameUpper;
		printProduct2.printNameInUpperCase(new Product(), "samsung");

		// Customer
		OneParameterCustomerObjectInterface printCustomer = (customer, name) -> customer.printNameUpper(name);
		printCustomer.printNameInUpperCase(new Customer(), "Jack");

		OneParameterCustomerObjectInterface printCustomer2 = Customer::printNameUpper;
		printCustomer2.printNameInUpperCase(new Customer(), "Jack");
	}

	public static void req2() {
		// write the LE for the methods which take 2 parameters and does not return anything
		// Product
		TwoParameterProductObjectInterface printProduct3 = (product, productId, name) -> product
				.printProductDetails(productId, name);
		printProduct3.display(new Product(), 11, "Jackson");

		TwoParameterProductObjectInterface printProduct4 = Product::printProductDetails;
		printProduct4.display(new Product(), 11, "Jackson");
		// customer
		TwoParameterCustomerObjectInterface printCustomer3 = (customer, customerId, name) -> customer
				.printCustomerDetails(customerId, name);
		printCustomer3.display(new Customer(), 101, "Jackson");

		TwoParameterCustomerObjectInterface printCustomer4 = Customer::printCustomerDetails;
		printCustomer4.display(new Customer(), 101, "Jackson");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		req1();

//		req2();

	}

}


/* 
 * carrying the interface along with the application is not a good practice.
 * this is where standard functional interfaces are used.
 */