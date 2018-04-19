package banking;

import java.text.DecimalFormat;

public class SavingsAccount extends BankAccount {

	protected double interestRate;
	protected double minimumBalance;
	
	public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
		
		System.out.println("Enter the yearly interest rate: ");
		interestRate = Assign7.in.nextDouble();
		
		System.out.println("Enter a minimum balance: ");
		minimumBalance = Assign7.in.nextDouble();
		
		//TODO exception handling for these fields
		
		return true;
	}
	
	@Override
	public void monthlyAccountUpdate() {
		//TODO: put decimal format as protected static in bankAccount class?
		DecimalFormat df = new DecimalFormat("$###,###.##");
		
		if (balance>minimumBalance) {
			balance += balance * (interestRate/12);
		}
		else {
			System.err.println("Minimum balance of " + df.format(minimumBalance) + " in account " + accNumber + " has not been met");
		}
		
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return super.toString() + " | Interest Rate: " + interestRate + "% | Minimum Balance: " + df.format(minimumBalance);
	}

	public double getInterest() {
		return interestRate;	
	}
	
	public double getMinBalance() {
		return minimumBalance;
	}

}
