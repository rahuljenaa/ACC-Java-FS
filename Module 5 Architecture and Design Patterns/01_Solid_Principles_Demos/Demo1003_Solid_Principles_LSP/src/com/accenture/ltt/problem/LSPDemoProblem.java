package com.accenture.ltt.problem;
//Base Class
abstract class Account {
    protected double amount;

    public void deposit(double amt) {
        amount += amt;
    }
 //  Parent promises every account supports withdraw
    public abstract void withdraw(double amt);
}
//Working Child Class
class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000;

    @Override
    public void withdraw(double amt) {
        if ((amount - amt) < MIN_BALANCE) {
            throw new RuntimeException("Below minimum balance! ");
        }
        amount -= amt;
    }
}
//Problematic Child Class

class FixedTermDepositAccount extends Account {

    @Override
    public void withdraw(double amt) {
        //  Parent allowed withdrawal but child COMPLETELY rejects it
        throw new RuntimeException("Withdrawal not allowed before maturity! ");
    }
}
//What goes Wrong
public class LSPDemoProblem {

	public static void main(String[] args) {
		Account account = new FixedTermDepositAccount(); //  Valid substitution

        account.deposit(10000);

        account.withdraw(2000); 
        //  Runtime failure!
        // Because FD Account does not allow withdrawal
	}

}
