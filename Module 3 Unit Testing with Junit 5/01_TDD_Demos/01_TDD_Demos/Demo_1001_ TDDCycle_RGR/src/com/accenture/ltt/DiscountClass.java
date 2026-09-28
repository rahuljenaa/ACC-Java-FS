package com.accenture.ltt;

public class DiscountClass {
	
	public static double calculate(double price, double discountPercent) {
		// To Show the Phase - 1 Red Uncomment the below code
		return 0;
		
		//To Show the Phase - 2 Green Uncomment the below code
	    //return price;
	    
		
		// To Show the Phase - 3 Refactor Uncomment the below code
	    //return findDiscount(price, discountPercent);
	}
	
	private static double findDiscount(double price, double discountPercent) {
		return price - (price * discountPercent / 100);
	}
}
