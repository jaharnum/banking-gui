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
	
	protected char source = 'x';
	
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
		super("The " + Bank.getName() + " Banking System");
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
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JFrame option = null;
			
			if (e.getSource()==addJButton) {
				AddFrame addAccount = new AddFrame();
				option = addAccount;
				source = 'a';
			} 
			
			else if (e.getSource()==displayJButton) {
				DisplayFrame displayAccount = new DisplayFrame();
				option = displayAccount;
				source = 'd';
			} 
			
			else if (e.getSource()==printJButton) {
				PrintFrame printAccount = new PrintFrame();
				option = printAccount;
				source = 'p';
			} 
			
			else if (e.getSource()==updateJButton) {
				UpdateFrame updateAccount = new UpdateFrame();
				option = updateAccount;
				source = 'u';
			} 
			else if (e.getSource()==monthlyJButton) {
				//TODO popup that says if update was successful, asks if user would like to print all accounts
			}
			
			else if (e.getSource()==importJButton) {
				//nothing  yet! 
			}
			
				option.setSize(500,600);
				option.setVisible(true);		
		} //end actionPerformed
		
	} //end ButtonHandler
	
	public char getSource() {
		return source;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); //set background
	}


}
