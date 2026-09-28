package com.accenture.ltt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.accenture.ltt.DiscountClass;

public class DiscountTestClass {
	
	@Test
	public void testReturningSamePriceIfNoDiscount() {
		// To Show the Phase - 1 Red Uncomment the below code[Also for Phase - 2 Green]
		assertEquals(100, DiscountClass.calculate(100, 0));
		
		//To Show the Phase  - 3 Refactor Uncomment the below code
		assertEquals(90, DiscountClass.calculate(100, 10));// Test Case Passed for the Discount price = 10%
		assertEquals(90, DiscountClass.calculate(100, 20));// Test Case Passed for the Discount price = 20%
	}

}
