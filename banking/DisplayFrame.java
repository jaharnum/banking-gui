package banking;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * DisplayFrame is dual purpose - it provides both display only and is also used to update accounts. 
 * Unfortunately for some reason the first time DisplayFrame is accessed through the update account button, it will always show the selectionPane first.
 * I couldn't find a way to resolve this issue, but if you exit out and click the button again it will show the updatePane as normal.
 * @author Jamie Harnum
 * @see BankFrame
 */
public class DisplayFrame extends JFrame {

	private JLabel displayJLabel;
	private JLabel updateJLabel;
	private JPanel selectionPane;
	private JTextField selectAccount;
	private JLabel selectAccountJLabel;
	private JLabel updateAccountJLabel;
	private String accNum;
	private JButton findAccountButton;
	private JLabel errorMsg;
	private JPanel displayPane;
	private JLabel foundIntroJLabel;
	private JLabel foundAccountJLabel;
	protected BankAccount foundAccount;
	private JPanel updatePane;
	private JTextField updateAccount;
	private JTextField updateAmount;
	private JButton depositButton;
	private JButton withdrawButton;
	private JPanel notFoundPane;
	private JLabel notFoundJLabel;
	private JButton searchAgainButton;
	private JButton exitJButton;
	private Color background;
	
	protected char display = 'd';

	private Color lGoldColor = new Color(245, 212, 100);
	private Color lGreenColor = new Color(68, 167, 127);
	private Font allLabels = new Font("Calibri", Font.PLAIN, 20);

	/**
	 * Instantiates the main components for the DisplayFrame and adds the methods that will provide the other JPanels for this frame
	 */
	public DisplayFrame() {
		super("The " + Assign7.bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 30));
		

		background = new Color(13, 58, 40);

		searchAgainButton = new JButton("Search Again");
		searchAgainButton.addActionListener(new ButtonHandler());
		
		exitJButton = new JButton("Return to Menu");
		exitJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});

		selectionPane();
		updatePane();
		displayPane();
		notFoundPane();
		add(exitJButton);
		
		if(display=='u') {
			selectionPane.setVisible(false);
			updatePane.setVisible(true);
			repaint();
		} else if (display=='d'){
			selectionPane.setVisible(true);
			updatePane.setVisible(false);
			repaint();
		}

	}

	/**
	 * Components provide the selection interface to the user
	 */
	protected void selectionPane() {
		selectionPane = new JPanel(new GridLayout(0, 1, 0, 10));
		selectionPane.setOpaque(false);
		
		displayJLabel = new JLabel("Display Account", JLabel.CENTER);
		displayJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		displayJLabel.setForeground(lGoldColor);

		selectAccountJLabel = new JLabel("Which account would you like to display?");
		selectAccountJLabel.setFont(allLabels);
		selectAccountJLabel.setForeground(lGreenColor);

		selectAccount = new JTextField(10);
		selectAccount.setToolTipText("Enter an account number");
		selectAccount.addActionListener(new BadInputHandler());

		findAccountButton = new JButton("Find Account");
		findAccountButton.addActionListener(new ButtonHandler());
		findAccountButton.setEnabled(false);

		errorMsg = new JLabel("Account numbers must be an integer");
		errorMsg.setFont(new Font("Calibri", Font.BOLD, 20));
		errorMsg.setForeground(Color.RED);
		errorMsg.setVisible(false);

		selectionPane.add(displayJLabel);
		selectionPane.add(selectAccountJLabel);
		selectionPane.add(selectAccount);
		selectionPane.add(findAccountButton);
		selectionPane.add(errorMsg);

		add(selectionPane);
		selectionPane.setVisible(true);

	}

	/**
	 * If the account is found through the selectionPane, the displayPane will be made visible and have the account info added to it
	 */
	private void displayPane() {
		displayPane = new JPanel(new GridLayout(0, 1, 0, 20));
		displayPane.setOpaque(false);

		displayPane.add(searchAgainButton);

		add(displayPane);
		displayPane.setVisible(false);

	}
	
	/**
	 * Combines searching for a particular account and updating its balance. Rather than using negative numbers, the user is given the option to select if they want the specified amount withdrawn or deposited to the account
	 */
	private void updatePane() {
		updatePane = new JPanel(new GridLayout(0, 1, 0, 20));
		updatePane.setOpaque(false);
		
		updateJLabel = new JLabel("Update Account", JLabel.CENTER);
		updateJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		updateJLabel.setForeground(lGoldColor);
		
		updateAccountJLabel = new JLabel("Which account would you like to update?");
		updateAccountJLabel.setFont(allLabels);
		updateAccountJLabel.setForeground(lGreenColor);
		
		updateAccount = new JTextField(10);
		updateAccount.setToolTipText("Enter the account number");
		updateAccount.addActionListener(new BadInputHandler());
	
		JLabel updateAmountJLabel = new JLabel("How much would you like to deposit or withdraw?");
		updateAmountJLabel.setFont(allLabels);
		updateAmountJLabel.setForeground(lGreenColor);
		
		//bad input for the updateAmount is handled by the UpdateHandler()
			updateAmount = new JTextField(10);
			updateAmount.setToolTipText("Enter a positive number that you would like to deposit or withdraw");

			depositButton = new JButton("Deposit to Account");
			depositButton.addActionListener(new ButtonHandler());
			depositButton.addActionListener(new UpdateHandler());

			withdrawButton = new JButton("Withdraw from Account");
			withdrawButton.addActionListener(new ButtonHandler());
			withdrawButton.addActionListener(new UpdateHandler());
		
		updatePane.add(updateJLabel);
		updatePane.add(updateAccountJLabel);
		updatePane.add(updateAccount);
		updatePane.add(updateAmountJLabel);
		updatePane.add(updateAmount);
		
		JPanel innerUpdatePane = new JPanel(new GridLayout(0, 2, 0, 10));
		innerUpdatePane.add(depositButton);
		innerUpdatePane.add(withdrawButton);
		
		updatePane.add(innerUpdatePane);
		
		add(updatePane);
	
	}

	/**
	 * If an account is not found, this pane will display its components and invite the user to try again.
	 */
	private void notFoundPane() {
		notFoundPane = new JPanel();
		GroupLayout notFound = new GroupLayout(notFoundPane);
		notFoundPane.setLayout(notFound);
		notFoundPane.setOpaque(false);

		notFoundJLabel = new JLabel("Sorry, we couldn't find an account with that number");
		notFoundJLabel.setFont(allLabels);
		notFoundJLabel.setForeground(lGreenColor);

		notFound.setAutoCreateContainerGaps(true);
		notFound.setAutoCreateGaps(true);
		
		notFound.setHorizontalGroup(
				notFound.createSequentialGroup().addGroup(notFound.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(notFoundJLabel).addComponent(searchAgainButton)));

		notFound.setVerticalGroup(
				notFound.createSequentialGroup().addComponent(notFoundJLabel).addComponent(searchAgainButton));

		add(notFoundPane);
		notFoundPane.setVisible(false);
	}

	/**
	 * Sets the appropriate panes to visible or not visible depending on the result of the searchAccounts() method
	 *
	 */
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
				accNum = selectAccount.getText();

				try {
					Long accNumToFind = Long.parseLong(accNum);

					foundAccount = Bank.searchAccounts(accNumToFind);

					if (foundAccount == null) {
						notFoundPane.setVisible(true);
						displayPane.setVisible(false);
						selectionPane.setVisible(false);

					} else {
						notFoundPane.setVisible(false);
						selectionPane.setVisible(false);

						foundIntroJLabel = new JLabel("Here is the account info for account #" + accNum);
						foundIntroJLabel.setFont(allLabels);
						foundIntroJLabel.setForeground(lGreenColor);

						foundAccountJLabel = new JLabel(
								"<html><div WIDTH=300><center>" + foundAccount.toString() + "</center></div></html>");
						foundAccountJLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
						foundAccountJLabel.setForeground(lGreenColor);
						
						if(e.getSource().equals(findAccountButton)) {
							displayPane.add(foundIntroJLabel, 0);
							displayPane.add(foundAccountJLabel, 1);
							displayPane.repaint();
							displayPane.setVisible(true);
						} else {
							updatePane.add(foundAccountJLabel, 1);
						}

					}

				} catch (NumberFormatException notLong) {
					errorMsg.setVisible(true);
				} //end catch

			}//end actionperformed
		}//end buttonhandler


	/**
	 * Checks for bad input
	 *
	 */
	private class BadInputHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String accNum = selectAccount.getText();
			try {
				Integer.parseInt(accNum);
				findAccountButton.setEnabled(true);
				errorMsg.setVisible(false);
			} catch (Exception notInt) {
				errorMsg.setVisible(true);
			}
			}
		}

	/**
	 * Updates the account depending on whether the withdraw or deposit button has been selected
	 *
	 */
	private class UpdateHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String amount = updateAmount.getText();

			JLabel newBalance = new JLabel();

			try {
				double amountDouble = Double.parseDouble(amount);
				if (e.getSource() == withdrawButton) {
					amountDouble = 0 - amountDouble;
					foundAccount.updateBalance(amountDouble);
					repaint();
				} else {
					foundAccount.updateBalance(amountDouble);
					repaint();
				}

				newBalance.setText("The new balance is " + foundAccount.getBalance());
				newBalance.setFont(allLabels);
				newBalance.setForeground(lGreenColor);
				displayPane.add(newBalance);
				repaint();

			} catch (Exception notDouble) {
				errorMsg.setVisible(true);
			}

		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); // set background
	}

}