package com.accenture.ltt.threading.activity;

//TODO 1 - extend Thread class
class MyThread extends Thread{
	
//Overriding run method
	public void run() {

		//TODO 2 - Write a for loop which runs 5 times and each time it is called, print three system.out.println statements with thread name and loop counter
		// 1. Entering into the method 
		// 2. Inside the method 
		// 3. Exiting from the method 
		for(int i = 0; i<5; i++) {
			System.out.println("Entering method ------ " + Thread.currentThread().getName() + " ----- value of i " + i);
			System.out.println("inside method " + Thread.currentThread().getName()+ " value of i " + i);
			System.out.println("Existing method ------ " + Thread.currentThread().getName()  + " ----- value of i " + i);
		}
	}
}
