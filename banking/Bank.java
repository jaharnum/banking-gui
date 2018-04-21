package banking;

import java.util.ArrayList;

/**
 * An instance of this class is used to store the ArrayList of BankAccounts used
 * by the program.
 * 
 * @author Jamie Harnum
 * @version 3.0
 */
public class Bank {

	/**
	 * The name of the instance of the Bank class
	 */
	private String bankName;

	/**
	 * The ArrayList of BankAccounts to be used by the program
	 */
	protected static ArrayList<BankAccount> accounts;

	/**
	 * The current number of existing accounts
	 */
	protected int numAccounts;

	/**
	 * Constructor for the Bank object that assigns the name variable and
	 * instantiates the ArrayList of BankAccounts
	 * 
	 * @param bankName
	 *            The string representing the name of the bank
	 */
	public Bank(String bankName) {
		this.bankName = bankName;
		accounts = new ArrayList<BankAccount>();
	}

	/**
	 * Legacy method from previous version that checks whether the account was
	 * created successfully. Likely to be deleted or altered.
	 * 
	 * @param newAccount
	 * @return The boolean representation of whether account creation was successful
	 *         (true) or not (false)
	 */
	public boolean addAccount(BankAccount newAccount) {
		// TODO fix this
		try {
			accounts.add(newAccount);
			numAccounts++;
			return true;
		} catch (Exception e) {
			// TODO exception handling
			return false;
		}

	}// end addAccount()

	/**
	 * Loops through the BankAccount ArrayList and calls the monthlyAccountUpdate
	 * method on all of them.
	 */
	public void monthlyUpdate() {

		for (BankAccount acc : accounts) {
			acc.monthlyAccountUpdate();
		}
	} // end monthlyUpdate

	/**
	 * Loops through the BankAccount ArrayList to see if any accounts have an
	 * account number matching the account number being looked for
	 * 
	 * @param accNumToFind
	 *            The number of the account the user wishes to find
	 * @return The BankAccount if one is found, otherwise null.
	 */
	public static BankAccount searchAccounts(long accNumToFind) {

		for (BankAccount acc : accounts) {
			if (acc.getAccNumber() == accNumToFind) {
				return acc;
			}
		}
		return null;
	}

	/**
	 * Gets the current number of accounts
	 * 
	 * @return The int representing the current number of accounts
	 */
	public int getNumAccounts() {
		return numAccounts;
	}

	/**
	 * Gets the name of the Bank object
	 * 
	 * @return The String representing the Bank's name
	 */
	public String getName() {
		return bankName;
	}

} // end class
