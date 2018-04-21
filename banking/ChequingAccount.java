package banking;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jamie Harnum
 * @see BankAccount
 */
public class ChequingAccount extends BankAccount {

	protected double fee;

public boolean addChequingAccount() {
		//TODO assess if you actually need this method...
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
			JOptionPane.showMessageDialog(Assign7.menu, "Insufficient funds to charge " + df.format(fee) + " on account " + accNumber, "Import Error", JOptionPane.ERROR_MESSAGE);
			
		}
	} //end monthlyAccountUpdate

}