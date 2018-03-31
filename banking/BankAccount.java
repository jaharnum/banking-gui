package banking;

import java.text.DecimalFormat;

public abstract class BankAccount {
	
	protected long accNumber;
	protected double balance;
	protected String customerName;
	
	public long getAccNumber() {
		return accNumber;
	}
	
	public boolean addBankAccount() {
		
		//prompt user for a new account number
		System.out.println("Enter a new account number:");
		long newAccNum = Assign7.in.nextLong();
		
		// check if number is duplicate
		//TODO loop to re-request number
		if (Bank.searchAccounts(newAccNum) != null) {
			System.out.print("That account number is already in use");
			return false;
		}
		
		//prompt for customer name
		System.out.println("What is the account holder's name?");
		
		//prompt for initial balance
		
		
		return false;
	}
	
	public boolean withdraw(double amount) {
		if (amount > balance) {
			return false;
		}
		else {
			balance -= amount;
			return true;
		}
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return "Account number: " + accNumber + " | Balance: " + df.format(balance);
		
	}
	
	public abstract void monthlyAccountUpdate();

}
