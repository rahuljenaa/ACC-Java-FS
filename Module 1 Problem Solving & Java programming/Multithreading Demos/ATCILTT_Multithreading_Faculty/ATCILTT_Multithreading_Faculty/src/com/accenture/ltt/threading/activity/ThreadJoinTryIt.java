package com.accenture.ltt.threading.activity;
//TODO 1 - extends the class with Thread class
public class ThreadJoinTryIt extends Thread{
	
	public void run() {
		//printing the thread name on entering the method 
		System.out.println("Thread started:::" + Thread.currentThread().getName());
		
		// TODO 2 -Call Thread.sleep method for 4 sec
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//printing the thread name on exiting from the method 
		System.out.println("Thread ended:::" + Thread.currentThread().getName());
	}

}
