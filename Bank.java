package banking;

import java.util.ArrayList;

public class Bank {
	
	private String bankName;
	
	private static ArrayList<BankAccount> accounts;
	
	public Bank(String bankName) {
		this.bankName = bankName;
		accounts = new ArrayList<BankAccount>();
	}
	
	public boolean addAccount() {
		
		//prompt user for information
		System.out.println("Enter details for account number #" + (accounts.size() + 1));
		
		BankAccount tempAccount;
		char option = 'x';
		
		//TODO - put this in a loop
		System.out.println("Enter 'c' for Chequing, 's' for Savings");
		option = Assign7.in.next().toLowerCase().charAt(0);
		
		if (option == 'c') {
			tempAccount = new ChequingAccount();
		}
		else if (option == 's') {
			tempAccount = new SavingsAccount();
		}
		else {
			System.out.println("I'm sorry, that's not a valid option");
			tempAccount = null;
		}
		
		if (tempAccount.addBankAccount()) {
			accounts.add(tempAccount);
			System.out.println("Account created successfully");
			return true;
		} 
		else {
			System.out.println("I'm sorry, the account was not created successfully");
			return false;
		}
		
	}//end addAccount()
	
	public void displayAccount() {
		
		System.out.println(findAccount());
		//will print either null or the account object method toString() - java will look for this automatically
		//TODO - exception handling if(findAccount()==null)
		
	}//end displayAccount()
	
	public void printAccountDetails() {
		
		//TODO pretty header kind of deal
		
		for (BankAccount b : accounts) {
			System.out.println(b);
			//print the object - calls toString()
		}
	} //end printAccountDetails
	
	public boolean updateAccount() {
		
		//find an account to update
		BankAccount b = findAccount();
		
		//prompt for amount
		System.out.println("Enter an amount:");
		Double amount = Assign7.in.nextDouble();
		
		if (amount < 0) {
			if (!b.withdraw(amount)) {
				System.out.println("Insufficient funds.");
				return false;
			}
			else {
				b.withdraw(amount);
				return true;
			}
		}
		else if (amount > 0) {
			b.deposit(amount);
			return true;
		}
		else {
			System.out.println("No update to perform");
			return false;
		}
	}//end update

	public void monthlyUpdate() {
		
		for (BankAccount b : accounts) {
			b.monthlyAccountUpdate();
		}
	} //end monthlyUpdate
	
	public BankAccount findAccount() {
		
		//prompt the user for an account number to find
		System.out.println("Enter an account number:");
		
		return searchAccounts(Assign7.in.nextLong());
	}
	
	public static BankAccount searchAccounts(long accNumToFind) {
		
		for (BankAccount b: accounts) {
			if (b.getAccNumber() == accNumToFind) {
				return b;
			}
		}
		return null;
	}
	
} //end class
