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

public class BankFrame extends JFrame {
	
	private JLabel menuJLabel;
	private JButton addJButton;
	private JButton displayJButton;
	private JButton printJButton;
	private JButton updateJButton;
	private JButton monthlyJButton;
	private JButton importJButton;
	private JButton exitJButton;
	private Color background;
	
	/*
	 * Color codes:
	 * 13, 58, 40 - darker green, background color. 
	 * 68, 167, 127 - main text, lighter green. 
	 * 245, 212, 100 - special text, light gold.
	 * 121, 244, 195 - very light green, accent
	 * 225, 225, 126 - very light gold, accent
	 * 35, 111, 80 - middling green, accent
	 */
	private Color lGoldColor = new Color(245, 212, 100);
	private Color lGreenColor = new Color(68, 167, 127);

	public BankFrame() {
		super("The " + Assign7.bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 30));
		
		background = new Color(13, 58, 40);
		menuJLabel = new JLabel("Main Menu", JLabel.CENTER);
		menuJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		menuJLabel.setForeground(lGoldColor);
		
		addJButton = new JButton("Add New Account");
		addJButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
					AddFrame addAccount = new AddFrame();
					addAccount.setSize(400, 600);
					addAccount.setVisible(true);
			}
		});
		
		displayJButton = new JButton("Display an Account");
		displayJButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DisplayFrame displayAccount = new DisplayFrame();
						displayAccount.setSize(400, 600);
						displayAccount.setVisible(true);
					} //end actionPerformed
				}//end inner class
				); //end addActionListener
		
		printJButton = new JButton("Print All Accounts");
		printJButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PrintFrame printAccount = new PrintFrame();
						printAccount.setSize(400, 600);
						printAccount.setVisible(true);
					}// end actionPerformed
				}); //end inner class and addactionlistener
		
		updateJButton = new JButton("Update an Account");
		updateJButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//direct user to update frame
					}//end actionPerformed
				});
		
		monthlyJButton = new JButton("Monthly Processing");
		monthlyJButton.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PrintFrame printAccount = new PrintFrame();
						printAccount.setSize(400, 600);
						printAccount.setVisible(true);
						
						//TODO add "if" statements to print frame to detect if its a monthly update and set some elements visible / invisible in that case
					} //end action performed
				});
		
		importJButton = new JButton("Import from File");
		importJButton.setEnabled(false);
		
		exitJButton = new JButton("Exit");
		exitJButton.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}//end actionperformed
				});
		
		add(menuJLabel);
		add(addJButton);
		add(displayJButton);
		add(printJButton);
		add(updateJButton);
		add(monthlyJButton);
		add(importJButton);
		add(exitJButton);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); //set background
	}


}
