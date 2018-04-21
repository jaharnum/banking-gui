package banking;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * BankFrame is the main menu frame for this program.
 * 
 * @author Jamie Harnum
 *
 */
public class BankFrame extends JFrame {

	private JLabel menuJLabel;
	private JButton addJButton;
	private JButton displayJButton;
	private JButton printJButton;
	private JButton updateJButton;
	private JButton monthlyJButton;
	private JLabel updateJLabel;
	private JButton importJButton;
	private JLabel success;
	private JLabel noSuccess;
	private JButton exitJButton;
	private Color background;

	protected char source = 'x';

	JFrame option = null;

	protected AddFrame addAccount;
	DisplayFrame updateAccount;

	private Color lGoldColor = new Color(245, 212, 100);
	private Color lGreenColor = new Color(68, 167, 127);
	
	/*
	 * Instantiates all the components of the BankFrame
	 */
	public BankFrame() {
		super("The " + Assign7.bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 30));

		background = new Color(13, 58, 40);
		menuJLabel = new JLabel("Main Menu", JLabel.CENTER);
		menuJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		menuJLabel.setForeground(lGoldColor);

		ButtonHandler handler = new ButtonHandler();

		addJButton = new JButton("Add New Account");
		addJButton.addActionListener(handler);

		displayJButton = new JButton("Display an Account");
		displayJButton.addActionListener(handler);

		printJButton = new JButton("Print All Accounts");
		printJButton.addActionListener(handler);

		updateJButton = new JButton("Update an Account");
		updateJButton.addActionListener(handler);

		monthlyJButton = new JButton("Monthly Processing");
		monthlyJButton.addActionListener(handler);

		updateJLabel = new JLabel("Monthly update complete!");
		updateJLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		updateJLabel.setForeground(lGoldColor);
		updateJLabel.setVisible(false);

		importJButton = new JButton("Import from File");
		importJButton.addActionListener(handler);

		success = new JLabel("File imported successfully!");
		success.setFont(new Font("Calibri", Font.PLAIN, 25));
		success.setForeground(lGoldColor);
		success.setVisible(false);

		noSuccess = new JLabel("Sorry, we could not import your file");
		noSuccess.setFont(new Font("Calibri", Font.PLAIN, 25));
		noSuccess.setForeground(Color.RED);
		noSuccess.setVisible(false);

		exitJButton = new JButton("Exit");
		exitJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}// end actionperformed
		});

		add(menuJLabel);
		add(addJButton);
		add(displayJButton);
		add(printJButton);
		add(updateJButton);
		add(monthlyJButton);
		add(updateJLabel);
		add(importJButton);
		add(success);
		add(noSuccess);
		add(exitJButton);

	}

	/**
	 * When any button is pressed, this handler processes the source and goes through the options to see which frame should be opened.
	 */
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() != monthlyJButton && e.getSource() != importJButton) {

				if (e.getSource() == addJButton) {
					addAccount = new AddFrame();
					addAccount.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					option = addAccount;
					source = 'a';
				}

				else if (e.getSource() == displayJButton) {
					DisplayFrame displayAccount = new DisplayFrame();
					displayAccount.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					option = displayAccount;
					displayAccount.display = 'd';
				}

				else if (e.getSource() == printJButton) {
					PrintFrame printAccount = new PrintFrame();
					printAccount.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					option = printAccount;
				}

				// known issue - after creating an account, the update frame won't change to be
				// the display account
				else if (e.getSource() == updateJButton) {

					updateAccount = new DisplayFrame();
					updateAccount.repaint();
					updateAccount.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					option = updateAccount;
					updateAccount.setName("updateAccount");
					updateAccount.display='u';
				}

				if (source == 'a') {
					option.setSize(500, 600);
					option.setVisible(true);
				} else {
					if (Assign7.bank.numAccounts == 0) {
						JOptionPane.showMessageDialog(Assign7.menu, "You haven't created any accounts yet",
								"Update Error", JOptionPane.ERROR_MESSAGE);
					} else {
						option.setSize(500, 700);
						option.setVisible(true);
					}
				}
			} else if (e.getSource() == monthlyJButton) {

				Assign7.bank.monthlyUpdate();

				updateJLabel.setVisible(true);

			}

			else if (e.getSource() == importJButton) {

				if (BankAccount.readRecords()) {
					success.setVisible(true);
					repaint();
				} else {
					noSuccess.setVisible(true);
					repaint();
				}
			} // end else if

		}// end actionperformed

	} // end ButtonHandler

	/**
	 * Allows the frame to be painted and repainted to "refresh" the variables
	 */
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); // set background
	}

}
