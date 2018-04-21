package banking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * The AddFrame is responsible for handling adding all the account information.
 * 
 * @author Jamie Harnum
 * @see BankFrame
 */
public class AddFrame extends JFrame {

	private JLabel addJLabel;
	private Color background;

	private JButton addButton;

	private Font allLabels = new Font("Calibri", Font.PLAIN, 20);

	private JPanel typePane;
	private JLabel accTypeDesc;
	private JRadioButton chequing;
	private JRadioButton savings;
	private ButtonGroup accountType;

	private JPanel infoPane;
	private JTextField accNumber;
	private JTextField fName;
	private JTextField lName;
	private JTextField phoneNum;
	private JTextField email;
	private JTextField balance;
	private JTextField fee;
	private JTextField interest;
	private JTextField minBalance;

	private JLabel errorMsg;

	private String accType;
	private String origin;

	private Color lGoldColor = new Color(245, 212, 100);
	private Color lGreenColor = new Color(68, 167, 127);

	/**
	 * Instatiates all the components of the AddFrame, including calling methods that add specific panes
	 */
	public AddFrame() {
		super("The " + Assign7.bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));

		background = new Color(13, 58, 40);
		addJLabel = new JLabel("Add Account", JLabel.CENTER);
		addJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		addJLabel.setForeground(lGoldColor);
		add(addJLabel);

		typePane();
		infoPane();

		errorMsg = new JLabel("Input invalid in the " + origin + " field");
		errorMsg.setFont(allLabels);
		errorMsg.setVisible(false);

		AddAccount add = new AddAccount();
		addButton = new JButton("Add Account");
		addButton.addActionListener(add);
		addButton.setEnabled(false);
		add(addButton);

	}

	/**
	 * The pane that provides the account type selection radio buttons
	 */
	private void typePane() {

		typePane = new JPanel(new BorderLayout());
		typePane.setOpaque(false);

		accTypeDesc = new JLabel("Select the account type:", JLabel.LEFT);
		accTypeDesc.setFont(allLabels);
		accTypeDesc.setForeground(lGreenColor);
		typePane.add(accTypeDesc, BorderLayout.WEST);

		ActionListener type = new TypeHandler();

		chequing = new JRadioButton("Chequing", false);
		typePane.add(chequing, BorderLayout.CENTER);
		chequing.addActionListener(type);
		chequing.setName("chequing");

		savings = new JRadioButton("Savings", false);
		typePane.add(savings, BorderLayout.EAST);
		savings.addActionListener(type);
		savings.setName("savings");

		accountType = new ButtonGroup();
		accountType.add(chequing);
		accountType.add(savings);

		add(typePane);

	}

	/**
	 * Provides all the components needed to get the account information from the user
	 */
	private void infoPane() {

		JLabel accNumberJLabel;
		JLabel nameJLabel;
		JLabel phoneJLabel;
		JLabel emailJLabel;
		JLabel balanceJLabel;
		JLabel feeJLabel;
		JLabel interestJLabel;
		JLabel minBalanceJLabel;

		infoPane = new JPanel();
		GroupLayout info = new GroupLayout(infoPane);
		infoPane.setLayout(info);
		infoPane.setOpaque(false);

		accNumberJLabel = new JLabel("Account Number: ", JLabel.LEFT);
		accNumberJLabel.setForeground(lGreenColor);
		accNumberJLabel.setFont(allLabels);

		nameJLabel = new JLabel("Name: ", JLabel.LEFT);
		nameJLabel.setForeground(lGreenColor);
		nameJLabel.setFont(allLabels);

		phoneJLabel = new JLabel("Phone Number: ", JLabel.LEFT);
		phoneJLabel.setForeground(lGreenColor);
		phoneJLabel.setFont(allLabels);

		emailJLabel = new JLabel("Email Address: ", JLabel.LEFT);
		emailJLabel.setForeground(lGreenColor);
		emailJLabel.setFont(allLabels);

		balanceJLabel = new JLabel("Balance: ", JLabel.LEFT);
		balanceJLabel.setForeground(lGreenColor);
		balanceJLabel.setFont(allLabels);

		feeJLabel = new JLabel("Fee: ", JLabel.LEFT);
		feeJLabel.setForeground(lGreenColor);
		feeJLabel.setFont(allLabels);

		interestJLabel = new JLabel("Interest Rate: ", JLabel.LEFT);
		interestJLabel.setForeground(lGreenColor);
		interestJLabel.setFont(allLabels);

		minBalanceJLabel = new JLabel("Minimum Balance: ", JLabel.LEFT);
		minBalanceJLabel.setForeground(lGreenColor);
		minBalanceJLabel.setFont(allLabels);

		BadInputHandler badInput = new BadInputHandler();

		accNumber = new JTextField(10);
		accNumber.addActionListener(badInput);
		accNumber.setName("accNumber");
		accNumber.setActionCommand("accNumber");

		fName = new JTextField("First Name", 10);
		fName.addActionListener(badInput);
		fName.setName("fName");
		fName.setActionCommand("fName");

		lName = new JTextField("Last Name", 10);
		lName.addActionListener(badInput);
		lName.setName("lName");
		lName.setActionCommand("lName");

		phoneNum = new JTextField(10);
		phoneNum.addActionListener(badInput);
		phoneNum.setName("phoneNum");
		phoneNum.setActionCommand("phoneNum");

		email = new JTextField(10);
		email.addActionListener(badInput);
		email.setName("email");
		email.setActionCommand("email");

		balance = new JTextField(10);
		balance.addActionListener(badInput);
		balance.setName("balance");
		balance.setActionCommand("balance");

		fee = new JTextField(10);
		fee.addActionListener(badInput);
		fee.setEnabled(false);
		fee.setName("fee");
		fee.setActionCommand("fee");

		interest = new JTextField(10);
		interest.addActionListener(badInput);
		interest.setEnabled(false);
		interest.setName("interest");
		interest.setActionCommand("interest");

		minBalance = new JTextField(10);
		minBalance.addActionListener(badInput);
		minBalance.setEnabled(false);
		minBalance.setName("minBalance");
		minBalance.setActionCommand("minBalance");

		fee.setBackground(Color.LIGHT_GRAY);
		interest.setBackground(Color.LIGHT_GRAY);
		minBalance.setBackground(Color.LIGHT_GRAY);

		info.setAutoCreateGaps(true);
		info.setAutoCreateContainerGaps(true);

		info.setHorizontalGroup(info.createSequentialGroup()
				// components that will be aligned horizonally go in the same group
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
						// group for jlabel components
						.addComponent(accNumberJLabel).addComponent(nameJLabel).addComponent(phoneJLabel)
						.addComponent(emailJLabel).addComponent(balanceJLabel).addComponent(feeJLabel)
						.addComponent(interestJLabel).addComponent(minBalanceJLabel))// end addGroup
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
						// group for jtextfield components
						.addComponent(accNumber).addComponent(fName).addComponent(phoneNum).addComponent(email)
						.addComponent(balance).addComponent(fee).addComponent(interest).addComponent(minBalance))// end
																													// addGroup
				.addComponent(lName) // lName is on its own bc its horizontal to the other name components

		);

		info.setVerticalGroup(
				// groups are components which should be on the same line vertically
				info.createSequentialGroup().addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
						// group for accNumber fields
						.addComponent(accNumberJLabel).addComponent(accNumber))
						.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
								// group for name fields
								.addComponent(nameJLabel).addComponent(fName).addComponent(lName))
						.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
								// group for phone fields
								.addComponent(phoneJLabel).addComponent(phoneNum))
						.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
								// group for email fields
								.addComponent(emailJLabel).addComponent(email))
						.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
								// group for balance fields
								.addComponent(balanceJLabel).addComponent(balance))
						.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
								// group for fee
								.addComponent(feeJLabel).addComponent(fee))
						.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
								// group for interest rate
								.addComponent(interestJLabel).addComponent(interest))
						.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING)
								// group for min balance
								.addComponent(minBalanceJLabel).addComponent(minBalance)));

		add(infoPane);
	}

	/**
	 * Allows the frame to be painted and repainted to refresh variables as needed
	 */
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); // set background
	}

	/**
	 * Handles the account type selection
	 *
	 */
	private class TypeHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == chequing) {
				fee.setEnabled(true);
				fee.setBackground(Color.WHITE);

				interest.setEnabled(false);
				interest.setBackground(Color.LIGHT_GRAY);

				minBalance.setEnabled(false);
				minBalance.setBackground(Color.LIGHT_GRAY);

				accType = "chequing";

				addButton.setEnabled(true);
			} else if (e.getSource() == savings) {
				interest.setEnabled(true);
				interest.setBackground(Color.WHITE);

				minBalance.setEnabled(true);
				minBalance.setBackground(Color.WHITE);

				fee.setEnabled(false);
				fee.setBackground(Color.LIGHT_GRAY);

				accType = "savings";

				addButton.setEnabled(true);
			} else {
				fee.setEnabled(false);
				fee.setBackground(Color.LIGHT_GRAY);

				interest.setEnabled(false);
				interest.setBackground(Color.LIGHT_GRAY);

				minBalance.setEnabled(false);
				minBalance.setBackground(Color.LIGHT_GRAY);

				addButton.setEnabled(false);

			}
		}
	} // end typehandler

	/**
	 * This handles all the information from the infoPane and adds it to a new account.
	 *
	 */
	protected class AddAccount implements ActionListener {

		protected long accNumAdd;
		protected Person accHolder;
		protected String fNameAdd = null;
		protected String lNameAdd = null;
		protected long phoneNumAdd = 0;
		protected String emailAdd = null;
		protected double balanceAdd = 0;
		protected double feeAdd = 0;
		protected double interestAdd = 0;
		protected double minBalanceAdd = 0;

		@Override
		public void actionPerformed(ActionEvent e) {

			for (Component c : infoPane.getComponents()) {

				if (c instanceof JTextField) {
					String origin = c.getName();
					String text = ((JTextField) c).getText();

					switch (origin) {
					case "accNumber":
						accNumAdd = Long.parseLong(text);
						break;

					case "fName":
						fNameAdd = text;
						break;

					case "lName":
						lNameAdd = text;
						break;

					case "phoneNum":
						// TODO check for number of digits and only containing digits

						phoneNumAdd = Long.parseLong(text);
						break;

					case "email":
						// TODO check for appropriate formatting
						emailAdd = text;
						break;

					case "balance":
						balanceAdd = Double.parseDouble(text);
						break;

					case "fee":
						if (accType == "chequing")
							feeAdd = Double.parseDouble(text);
						break;

					case "interest":
						if (accType == "savings")
							interestAdd = Double.parseDouble(text);
						break;

					case "minBalance":
						if (accType == "savings")
							minBalanceAdd = Double.parseDouble(text);
					}// end switch
				} // end if

			} // end for
			setAccInfo();

			dispose(); //after account info is set, the addFrame closes and the user returns to the menu
		}// end ActionListener

		public void setAccHolder() {
			accHolder = new Person(fNameAdd, lNameAdd, phoneNumAdd, emailAdd);
		}

		/**
		 * After all of the text from the JTextFields has been parsed, the setAccInfo() method sets it to a newAccount instance of BankAccount
		 */
		public void setAccInfo() {

			setAccHolder();

			if (accType == "chequing") {
				BankAccount newAccount = new ChequingAccount();
				newAccount.accNumber = accNumAdd;
				newAccount.accHolder = accHolder;
				newAccount.balance = balanceAdd;
				((ChequingAccount) newAccount).fee = feeAdd;
				Assign7.bank.addAccount(newAccount);
			} else {
				BankAccount newAccount = new SavingsAccount();
				newAccount.accNumber = accNumAdd;
				newAccount.accHolder = accHolder;
				newAccount.balance = balanceAdd;
				((SavingsAccount) newAccount).interestRate = interestAdd;
				((SavingsAccount) newAccount).minimumBalance = minBalanceAdd;
				Assign7.bank.addAccount(newAccount);
			}

		}

	}// end ActionPerformed

	/**
	 * Checks the user input to see if it is appropriate for the field being accessed. 
	 *
	 */
	private class BadInputHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField field = (JTextField) e.getSource();
			origin = e.getActionCommand();

			String text = field.getText();

			boolean isValid = false;

			switch (origin) {
			case "accNumber":
				try {
					Long.parseLong(text);
				} catch (Exception notLong) {
					JOptionPane.showMessageDialog(Assign7.menu.addAccount, "Account numbers must be numerical",
							"Add Account Error", JOptionPane.ERROR_MESSAGE);
				}

				if (Bank.searchAccounts(Long.parseLong(text)) != null) {
					JOptionPane.showMessageDialog(Assign7.menu.addAccount,
							"Sorry, this account number is already in use", "Add Account Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					isValid = true;
				}
				break;
			case "fName":
			case "lName":
				if (text.matches(".*[a-zA-Z].*")) {
					isValid = true;
				} else {
					JOptionPane.showMessageDialog(Assign7.menu.addAccount,
							"The account holder's names must contain alphabet characters", "Add Account Error",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "phoneNum":
				try {
					Integer.parseInt(text);
				} catch (Exception notInt) {
					JOptionPane.showMessageDialog(Assign7.menu.addAccount, "Not a valid phone number",
							"Add Account Error", JOptionPane.ERROR_MESSAGE);
				}
				if (text.length() < 11 && text.length() > 6) {
					isValid = true;
				}
				break;
			case "email":
				if (text.matches(".+@.+[.].+")) {
					isValid = true;
				} else {
					JOptionPane.showMessageDialog(Assign7.menu.addAccount, "Not a valid email address",
							"Add Account Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "balance":
			case "fee":
			case "interest":
			case "minBalance":
				try {
					double textNum = Double.parseDouble(text);
					if ((textNum * 100) % 1 != 0) {
						JOptionPane.showMessageDialog(Assign7.menu.addAccount, "Too many decimal places",
								"Add Account Error", JOptionPane.ERROR_MESSAGE);
					} else if (textNum < 0) {
						JOptionPane.showMessageDialog(Assign7.menu.addAccount, "You cannot input a negative number",
								"Add Account Error", JOptionPane.ERROR_MESSAGE);
					} else {
						isValid = true;
					}
				} catch (Exception notDouble) {
					JOptionPane.showMessageDialog(Assign7.menu.addAccount, "Not a valid number", "Add Account Error",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			}

			if (isValid) {
				errorMsg.setVisible(false);
			} else {
				errorMsg.setForeground(Color.RED);
				errorMsg.setVisible(true);
			}

		} // end actionPerformed

	} // end BadInputHandler

}
