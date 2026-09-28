package com.accenture.ltt.solution;
//Base Class
abstract class Account {
    protected double amount;

    public void deposit(double amt) {
        amount += amt;
    }

    public double getBalance() {
        return amount;
    }
}

// Only accounts that allow withdrawal extend this class
abstract class WithdrawableAccount extends Account
{
	public abstract boolean withdraw(double amt);
}

class SavingsAccount extends WithdrawableAccount {
    private static final double MIN_BALANCE = 1000;

    @Override
    public boolean withdraw(double amt) {
        if ((amount - amt) >= MIN_BALANCE) {
            amount -= amt;
            return true;
        }
        return false;
    }
}

class FixedTermDepositAccount extends Account {
    //  No withdraw method — now expectations are clear
}

public class LSPDemoSolution {

	public static void main(String[] args) {
		WithdrawableAccount sa = new SavingsAccount();
        sa.deposit(5000);
        sa.withdraw(2000);
        System.out.println(sa.getBalance()); //  Works

        Account fda = new FixedTermDepositAccount();
        fda.deposit(10000);
        //  No withdrawal, no behavior conflict
        System.out.println(fda.getBalance());

	}

}
