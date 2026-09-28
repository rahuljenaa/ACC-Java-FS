package com.accenture.ltt.lambdaexp.sample;

/**
 * Demonstration of how anonymous class is written 
 *
 */
public class Welcome {	
	
	public static void main(String[] args) {
		//creating anonymous class for Greeting implementation
		Greeting greeting = new Greeting() {			
			public void greet(String name) {
				System.out.println("Welcome "+name);				
			}			
		};	
		
		//calling greet method of Greeting interface
		greeting.greet("Seeta");		
	}
}
