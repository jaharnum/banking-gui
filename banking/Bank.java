package banking;

import java.util.ArrayList;

public class Bank {
	
	private static String bankName;
	protected static ArrayList<BankAccount> accounts;
	protected int numAccounts;
	
	public Bank(String bankName) {
		Bank.bankName = bankName;
		accounts = new ArrayList<BankAccount>();
	}
	
	public boolean addAccount(BankAccount newAccount) {
		//TODO fix this 
		try {
		accounts.add(newAccount);
		numAccounts++;
		return true;
		} 
		catch (Exception e) {
			//TODO exception handling
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
		
		for (BankAccount acc : accounts) {
			System.out.println(acc);
			//print the object - calls toString()
		}
	} //end printAccountDetails
	
	public void updateAccount() {
		
		//find an account to update
		BankAccount acc = findAccount();
		
		if (acc==null) {
			System.out.println("Account number requested not found");
			return;
		}
		
		//prompt for amount
		System.out.println("Enter an amount:");
		acc.updateBalance(Assign7.in.nextDouble());
		
	}//end update

	public void monthlyUpdate() {
		
		for (BankAccount acc : accounts) {
			acc.monthlyAccountUpdate();
		}
	} //end monthlyUpdate
	
	public BankAccount findAccount() {
		
		//prompt the user for an account number to find
		System.out.println("Enter an account number:");
		
		while(!Assign7.in.hasNextLong()) {
			System.out.println("Invalid account number. Please try again.");
			Assign7.in.next();
		}
		
		return searchAccounts(Assign7.in.nextLong());
	}
	
	public static BankAccount searchAccounts(long accNumToFind) {
		
		for (BankAccount acc: accounts) {
			if (acc.getAccNumber() == accNumToFind) {
				return acc;
			}
		}
		return null;
	}
	
	public int getNumAccounts() {
		return numAccounts;
	}

	public static String getName() {
		return bankName;
	}


	
} //end class
