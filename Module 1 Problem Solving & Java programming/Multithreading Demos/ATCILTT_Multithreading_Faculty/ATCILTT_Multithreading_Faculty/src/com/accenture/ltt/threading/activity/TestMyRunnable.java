package com.accenture.ltt.threading.activity;

public class TestMyRunnable {
	public static void main(String args[]) {
		System.out.println("Thread Name :" + Thread.currentThread().getName());

		// TODO 1 - Instantiate an object (say m1) of MyRunnableThread class
		MyRunnableThread r = new MyRunnableThread();

		// TODO 2 - Create 2 objects of Thread class and pass m1 and a thread name as its parameters
		Thread thread1 = new Thread(r, "THREADX");
		Thread thread2 = new Thread(r, "THREADY");
		// TODO 3 - Start both the threads using start()
		thread1.start();
		thread2.start();
	}
}
