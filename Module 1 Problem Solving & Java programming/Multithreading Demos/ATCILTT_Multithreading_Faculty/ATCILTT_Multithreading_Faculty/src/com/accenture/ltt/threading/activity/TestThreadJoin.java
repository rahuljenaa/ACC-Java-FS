package com.accenture.ltt.threading.activity;

/**
 * This class will create 2 thread object.
 * It will start the second thread once the first thread executed for 2 ms.
 * When both the threads complete their execution it will print message "All threads are dead, exiting main thread"
 *
 */
public class TestThreadJoin {

	public static void main(String[] args) throws InterruptedException{
		
		//TODO 1- creating two instances of Thread by passing ThreadJoinTryIt class and thread name
		ThreadJoinTryIt thread1 = new ThreadJoinTryIt();
		ThreadJoinTryIt thread2 = new ThreadJoinTryIt();
		
		//TODO 2- call start method on first thread		
		thread1.start();		
		//TODO 3 - call join method on thread 1 object by passing 2000 as its argument		
		thread1.join(2000);
		//TODO 4 - call start method on second thread object
		thread2.start();
		//TODO 5 - call join method on thread 1 and thread 2 object
		thread1.join();
		thread2.join();
		System.out.println("All threads are dead, exiting main thread");
	}

}
