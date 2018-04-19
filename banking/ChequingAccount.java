package banking;

import java.text.DecimalFormat;

public class ChequingAccount extends BankAccount {

	protected double fee;

public boolean addChequingAccount() {
		
	return true;
	}

public double getFee() {
	return fee;
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