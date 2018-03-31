package banking;

public class SavingsAccount extends BankAccount {

	private double interestRate;
	private double minBalance;
	
	//TODO constructor
	//TODO add methods
	
	public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
		
		//process these fields
		
		return false;
	}
	
	@Override
	public void monthlyAccountUpdate() {
		// TODO Auto-generated method stub
		
		if (balance>minBalance) {

		balance += balance * (interestRate/12);
		
		}
		
	}

}
