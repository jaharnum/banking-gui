package banking;

import java.text.DecimalFormat;

public class ChequingAccount extends BankAccount {

	private double fee;
	
public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
		
		System.out.println("Enter the monthly fee:");
		fee = Assign7.in.nextDouble();
		
		//TODO: exception handling for monthly fee
		
		return true;
	}
	
	public String toString() {
		return super.toString() + " | Monthly Fee: " + fee;
	}

	@Override
	public void monthlyAccountUpdate() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		
		if (balance>fee) {
			balance -= fee;
		}
		else {
			System.err.println("Insufficient funds to charge " + df.format(fee) + " on account " + accNumber);
			
		}
	} //end monthlyAccountUpdate

}