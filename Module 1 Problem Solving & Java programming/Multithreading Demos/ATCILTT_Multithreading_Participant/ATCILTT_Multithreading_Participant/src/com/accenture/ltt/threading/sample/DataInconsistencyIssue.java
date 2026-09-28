package com.accenture.ltt.threading.sample;

public class DataInconsistencyIssue extends Thread{

	
	float amount;
	SavingAccount savingAccount;
	
	//constructor of DataInconsistencyIssue class
	public DataInconsistencyIssue(float amount, SavingAccount savingAccount) {
		this.amount = amount;
		this.savingAccount = savingAccount;
	}
	
	
	@Override
	public void run() {
		//called withdraw method of SavingAccount
		savingAccount.withdraw(amount);		
	}
	
	public static void main(String[] args) throws InterruptedException {
		//Created object of SavingAccount  
		SavingAccount sa = new SavingAccount();
		
		//created two threads
		DataInconsistencyIssue thread1 = new DataInconsistencyIssue(400.0f, sa);
		DataInconsistencyIssue thread2 = new DataInconsistencyIssue(800.0f, sa);
		
		//starting both the threads
		thread1.start();
		thread2.start();
		
		/*calling join on both the threads so that main method 
		 * will print the value of balance when 
		 * both the threads finish their task 
		 */
		thread1.join();
		thread2.join();
		
		System.out.println("final balance is : " + sa.balance);
	}



}
