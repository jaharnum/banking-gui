package banking;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Abstract class that provides a base for the Chequing and Savings Accounts.
 * Also provides the import methods.
 * 
 * @author Jamie Harnum
 * @see ChequingAccount
 * @see SavingsAccount
 */
public abstract class BankAccount {

	protected long accNumber = 0;
	protected double balance = 0;
	protected Person accHolder;
	private static char accType;
	private static BankAccount b = null;

	/**
	 * The input scanner used to import text files
	 */
	private static Scanner input;

	/**
	 * Provides the account number of a particular account to other classes
	 * 
	 * @return The account number
	 */
	public long getAccNumber() {
		return accNumber;
	}

	/**
	 * Provides the account holder of a particular account to other classes
	 * 
	 * @return The Person representing the account holder
	 */
	public Person getAccHolder() {
		return accHolder;
	}

	/**
	 * Provides the balance of a particular account to other classes
	 * @return The balance of the account
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Updates the balance of the account
	 * @param amount The amount the user wishes to update the account by
	 */
	public void updateBalance(double amount) {
		if (amount < 0) {
			amount = Math.abs(amount);

			if (amount > balance) {
				JOptionPane.showMessageDialog(Assign7.menu, "Insufficient Funds", "Update Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			balance -= amount;
		} else {
			balance += amount;
		}
	}

	/**
	 * @return A String representation of the information in this BankAccount instance
	 */
	public String toString() {

		DecimalFormat df = new DecimalFormat("$###,###.##");
		return "Account number: " + accNumber + " | Name: " + accHolder.getName() + " | Phone Number: "
				+ accHolder.getPhoneNumber() + " | Email: " + accHolder.getEmail() + " | Balance: "
				+ df.format(balance);

	}

	/**
	 * Abstract class for the monthly update
	 */
	public abstract void monthlyAccountUpdate();
	
	
/**
 * Sets a specific file location and sets the scanner to read it
 * @param s The scanner to recieve the input
 * @return True if the file is successfully read
 */
	public static boolean readFile(Scanner s) {
		try {
			File file = new File("C:\\Users\\Jamie\\Documents\\W18\\CST8132\\Assign2\\src\\banking\\bankData.txt");
			input = new Scanner(file);
			return true;

		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Determines if a particular record in the file is a chequing or savings account and then passes to the readAccount() method to finish reading the account information.
	 * @return Whether the records have successfully been read or not
	 */
	public static boolean readRecords() {

		readFile(input);

		try {
			while (input.hasNext()) {

				accType = input.next().charAt(0);

				if (accType == 'c') {
					b = new ChequingAccount();
				} else if (accType == 's') {
					b = new SavingsAccount();
				}

				if (b.readAccount(input)) {
					Bank.accounts.add(b);
					Assign7.bank.numAccounts++;
				} else {
					JOptionPane.showMessageDialog(Assign7.menu, "Account could not be added", "Import Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(Assign7.menu, "Import could not be completed", "Import Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			closeFile();
		}
	}

	/**
	 * Closes the file scanner
	 */
	public static void closeFile() {
		if (input != null) {
			input.close();
		}
	}

	/**
	 * Scans through the text file for each piece of information needed to add the account.
	 * @param in The Scanner being used to read the file
	 * @return Whether or not the account information has been successfully added
	 */
	public boolean readAccount(Scanner in) {

		// input accNumber, person info, balance
		// return true (or false if error)
		try {
			this.accNumber = in.nextLong();

			this.accHolder = new Person(in.next(), in.next(), in.nextLong(), in.next());

			this.balance = in.nextDouble();

			if (accType == 'c') {
				((ChequingAccount) b).fee = in.nextDouble();
			} else if (accType == 's') {
				((SavingsAccount) b).interestRate = in.nextDouble();
				((SavingsAccount) b).minimumBalance = in.nextDouble();
			}

			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
