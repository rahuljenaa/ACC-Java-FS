package com.accenture.ltt.threading.sample;

public class TestRunnable {

	public static void main(String args[]) {
		// printing current thread name
		System.out.println(Thread.currentThread().getName());
		
		// creating two thread objects
		Thread thread1 = new Thread(new RunnableDemo());
		Thread thread2 = new Thread(new RunnableDemo());
		
		// starting both the threads
		thread1.start();
		thread2.start();
	}

}
