package com.accenture.ltt.threading.sample;

public class ThreadPriorityDemo extends Thread{
	
	//overriding run method of Thread class
	@Override
	public void run() {
		
		//printing thread name and priority
		
		System.out.println("Entering method ------ " + Thread.currentThread().getName());
		System.out.println("inside method " + Thread.currentThread().getName() + " having thread priority " +  Thread.currentThread().getPriority());
		System.out.println("Existing method ------ " + Thread.currentThread().getName());	
		
	}
	
	public static void main(String[] args) {
		
		//creating ThreadPriorityDemo class object
		ThreadPriorityDemo threadX = new ThreadPriorityDemo();
		threadX.setName("THREADX");
		//setting the thread priority to Maximum
		threadX.setPriority(MAX_PRIORITY);
		
		//creating another object 
		ThreadPriorityDemo threadY = new ThreadPriorityDemo();
		threadY.setName("THREADY");
		//setting the thread priority to minimum
		threadY.setPriority(MIN_PRIORITY);
		
		
		//creating another object 
		ThreadPriorityDemo threadZ = new ThreadPriorityDemo();
		threadZ.setName("THREADZ");
		//setting the thread priority to 4
		threadZ.setPriority(4);
		
		
		//starting the new thread
		threadX.start();
		threadY.start();
		threadZ.start();
		
	}

}
