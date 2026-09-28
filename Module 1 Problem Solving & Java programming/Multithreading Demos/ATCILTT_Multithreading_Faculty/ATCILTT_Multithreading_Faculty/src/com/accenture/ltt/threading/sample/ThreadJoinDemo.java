package com.accenture.ltt.threading.sample;

public class ThreadJoinDemo extends Thread {
	
	@Override
	public void run() {
		//loop from number 0 to 4
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			//calling Thread sleep method so that a thread sleep for 2 sec
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Exiting newly created thread");
	}

	public static void main(String[] args) throws InterruptedException {
		// creating an instance of ThreadJoinMainClass class
		ThreadJoinDemo thread = new ThreadJoinDemo();
		// calling start so that a new thread create and call run method on that
		thread.start();
		// execute main method once the thread method finish its execution
		//NOTE: execute this program after commenting call to join method
		thread.join();
		
		System.out.println("Exiting main thread");
	}
}
