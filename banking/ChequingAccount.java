package banking;

public class ChequingAccount extends BankAccount {

	private double monthlyFee;
	
public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
		
		//process these fields
		
		return false;
	}
	
	public String toString() {
		return super.toString() + " | Monthly Fee: " + monthlyFee;
	}

	@Override
	public void monthlyAccountUpdate() {
		balance -= monthlyFee;
		
		if (balance < 0) {
			System.out.println("Account " + accNumber + " overdrawn.");
		}
		
	}
}
