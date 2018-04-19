package banking;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class BankAccount {
	
	protected long accNumber = 0;
	protected double balance = 0;
	protected Person accHolder;

	
	public boolean addBankAccount() {
		
		
		//TODO fix this so it actually does something??? or get rid of it???
		
		/* do { 
			
			//prompt user for a new account number
			System.out.println("Enter a new account number:");
			String accN = Assign7.in.next();
			
			if (accN.length()<=8) {
				try {
					accNum = Long.parseLong(accN);
					
					if (Bank.searchAccounts(accNum) != null) {
						accNum = 0;
						System.out.println("Account number is already in use. Please try again.");
					}
				} catch (Exception e) {
					accNum=0;
					System.out.println("Invalid account number. Please try again");
				}
			}
			
		} while (accNum==0);
		
		accNumber = accNum;
		
		//TODO prompt for customer name + exception handling
		System.out.println("What is the account holder's last name?");
		String lName = Assign7.in.next();
		
		System.out.println("What is the account holder's first name?");
		String fName = Assign7.in.next();
		
		System.out.println("Enter the opening balance:");
		while (!Assign7.in.hasNextDouble()) {
			System.out.println("Invalid opening balance amount. Please try again:");
			Assign7.in.next();
		}
		balance = Assign7.in.nextDouble();
		
		long phoneNum=0;
		do {
			System.out.println("Enter a phone number:");
			String pNum = Assign7.in.next();
			
			if (pNum.length()==7 || pNum.length()==10) {
				try {
					phoneNum = Long.parseLong(pNum);
				} catch (Exception e) {
					phoneNum = 0;
					System.out.println("Invalid phone number. Please try again.");
				}
			}
		} while (phoneNum==0);
		
		//TODO exception handling for email
		System.out.println("Enter an email address:");
		String email = Assign7.in.next(); */
		
		return true;
	}

	public long getAccNumber() {
		return accNumber;
	}
	
	public Person getAccHolder() {
		return accHolder;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void updateBalance(double amount) {
		if (amount < 0) {
			amount = Math.abs(amount);
			
			if(amount>balance) {
				System.out.println("Insufficient funds.");
				return;
			}
			balance -= amount;
		}
		else {
			balance += amount;
		}
	}

	
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return "Account number: " + accNumber + " | Name: " + accHolder.getName() + " | Phone Number: " + accHolder.getPhoneNumber() +
								" | Email: " + accHolder.getEmail() + " | Balance: " + df.format(balance);
		
	}
	
	public abstract void monthlyAccountUpdate();

}
