package com.accenture.ltt.threading.activity;

public class TestMyThread {
	public static void main(String args[]) {
		System.out.println("Thread Name :" + Thread.currentThread().getName());
			
		//TODO 1 - create 2 threads by creating objects of MyThread class 				
		MyThread thread1 = new MyThread();
		thread1.setName("THREADX");
		MyThread thread2 = new MyThread();
		thread2.setName("THREADY");
		//TODO 2 - Start both the threads by using start()
		thread1.start();
		thread2.start();
	}
}
