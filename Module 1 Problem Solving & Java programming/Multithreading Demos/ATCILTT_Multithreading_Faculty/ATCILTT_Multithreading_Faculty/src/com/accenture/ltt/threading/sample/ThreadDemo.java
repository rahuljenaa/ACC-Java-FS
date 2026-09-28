package com.accenture.ltt.threading.sample;

public class ThreadDemo extends Thread {

	public void run() {
		// print out the name of the thread which is executing this method
		System.out.println("Thread name :" + Thread.currentThread().getName());
	}

}
