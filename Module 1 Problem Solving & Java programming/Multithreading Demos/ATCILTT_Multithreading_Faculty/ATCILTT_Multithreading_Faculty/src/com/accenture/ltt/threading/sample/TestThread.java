package com.accenture.ltt.threading.sample;

public class TestThread {
	


	public static void main(String args[]) {
		// printing current thread name
		System.out.println(Thread.currentThread().getName());
		
		// creating two thread objects
		ThreadDemo thread1 = new ThreadDemo();
		ThreadDemo thread2 = new ThreadDemo();
		
		// starting both the threads
		thread1.start();
		thread2.start();
	}



}
