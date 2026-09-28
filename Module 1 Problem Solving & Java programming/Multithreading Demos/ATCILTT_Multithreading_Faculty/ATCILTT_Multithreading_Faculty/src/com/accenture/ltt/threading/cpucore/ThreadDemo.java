package com.accenture.ltt.threading.cpucore;

public class ThreadDemo {

	 public static void main(String[] args) {
	     // Display the number of available CPU cores
	     int cores = Runtime.getRuntime().availableProcessors();
	     System.out.println("Number of CPU Cores: " + cores);
	     System.out.println("----------------------------------");

	     // Create and start multiple threads
	     for (int i = 1; i <= cores * 2; i++) { // creating 2x threads than cores
	         Thread worker = new Thread(new WorkerTask(), "Thread-" + i);
	         worker.start();
	     }
	 }
	}

	class WorkerTask implements Runnable {
	 @Override
	 public void run() {
	     // Each thread prints its name and simulates work
	     System.out.println(Thread.currentThread().getName() + " is running on " +
	             Thread.currentThread().getThreadGroup().getName());
	     
	     try {
	         // Simulate some workload
	         for (int i = 1; i <= 3; i++) {
	             System.out.println("   " + Thread.currentThread().getName() + " is working... step " + i);
	             Thread.sleep(500); // simulate computation time
	         }
	     } catch (InterruptedException e) {
	         System.out.println(Thread.currentThread().getName() + " interrupted.");
	     }

	     System.out.println(Thread.currentThread().getName() + " has finished execution.\n");
	 }
	}
