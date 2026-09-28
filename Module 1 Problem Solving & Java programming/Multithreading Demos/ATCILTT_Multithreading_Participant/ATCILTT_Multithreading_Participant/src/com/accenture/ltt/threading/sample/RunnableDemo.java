package com.accenture.ltt.threading.sample;

public class RunnableDemo implements Runnable {

	// implements run method of Runnable interface
	@Override
	public void run() {
		// print out the name of the thread which is executing this method
		System.out.println("Runnable Thread name :" + Thread.currentThread().getName());

	}

}
