package banking;

import java.text.DecimalFormat;

/**
 * 
 * @author Jamie Harnum
 * @see BankAccount
 */
public class SavingsAccount extends BankAccount {

	protected double interestRate;
	protected double minimumBalance;

	@Override
	public void monthlyAccountUpdate() {

		if (balance > minimumBalance) {
			balance += balance * (interestRate / 12);
		}

	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return super.toString() + " | Interest Rate: " + interestRate + "% | Minimum Balance: "
				+ df.format(minimumBalance);
	}

	public double getInterest() {
		return interestRate;
	}

	public double getMinBalance() {
		return minimumBalance;
	}

}
