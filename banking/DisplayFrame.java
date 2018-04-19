package banking;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayFrame extends JFrame {
	
	private JLabel displayJLabel;
	private JPanel selectionPane;
		private JTextField selectAccount;
			String accNum;
		private JButton findAccountButton;
		private JLabel errorMsg;
	private JPanel displayPane;
		private JLabel foundIntroJLabel;
		private JLabel foundAccountJLabel;
		BankAccount foundAccount=null;
	private JPanel notFoundPane;
		private JLabel notFoundJLabel;
	private JButton searchAgainButton;
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
	private Font allLabels = new Font("Calibri", Font.PLAIN, 20);


	public DisplayFrame(){
		super("The " + Bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 30));
		
		background = new Color(13, 58, 40);
		displayJLabel = new JLabel("Display Account", JLabel.CENTER);
		displayJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		displayJLabel.setForeground(lGoldColor);
		
		searchAgainButton = new JButton("Search Again");
		searchAgainButton.addActionListener(new ButtonHandler());
		
		
		add(displayJLabel);
		selectionPane();
		displayPane();
		notFoundPane();

	}
	
	private void selectionPane() {
		selectionPane = new JPanel();
		GroupLayout select = new GroupLayout(selectionPane);
		selectionPane.setLayout(select);
		selectionPane.setOpaque(false);
		
		JLabel selectAccountJLabel = new JLabel("Which account would you like to display?");
		selectAccountJLabel.setFont(allLabels);
		selectAccountJLabel.setForeground(lGreenColor);
		
		selectAccount = new JTextField("Enter account number", 10);
		selectAccount.addActionListener(new BadInputHandler());
		
		findAccountButton = new JButton("Find Account");
		findAccountButton.addActionListener(new ButtonHandler());
		findAccountButton.setEnabled(false);
	
		errorMsg = new JLabel("Account numbers must be an integer");
		errorMsg.setFont(new Font("Calibri", Font.BOLD, 20));
		errorMsg.setForeground(Color.RED);
		errorMsg.setVisible(false);
		
		select.setAutoCreateGaps(true);
		select.setAutoCreateContainerGaps(true);
		
		select.setHorizontalGroup(
				select.createSequentialGroup() 
				//components that will be aligned horizonally go in the same group
				.addGroup(select.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(selectAccountJLabel)
						.addComponent(selectAccount)
						.addComponent(findAccountButton)
						.addComponent(errorMsg)
				));
		
		select.setVerticalGroup(
				select.createSequentialGroup()
				//components that will be aligned vertically go in the same group
				.addComponent(selectAccountJLabel)
				.addComponent(selectAccount)
				.addComponent(findAccountButton)
				.addComponent(errorMsg)
						);


		add(selectionPane);
		selectionPane.setVisible(true);
		
		}
	
	private void displayPane() {
		displayPane = new JPanel();
		GroupLayout display = new GroupLayout(displayPane);
		displayPane.setLayout(display);
		displayPane.setOpaque(false);
		
		display.setAutoCreateGaps(true);
		display.setAutoCreateContainerGaps(true);
		
		foundIntroJLabel = new JLabel("Here is the account info for account #" + accNum);
		foundIntroJLabel.setFont(allLabels);
		foundIntroJLabel.setForeground(lGreenColor);
		
		if (foundAccount!=null) {
			foundAccountJLabel = new JLabel(foundAccount.toString());
			foundAccountJLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
			foundAccountJLabel.setForeground(lGreenColor);

		
		display.setHorizontalGroup(
				display.createSequentialGroup()
				.addGroup(display.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(foundIntroJLabel)
						.addComponent(foundAccountJLabel)
						.addComponent(searchAgainButton)
						));
		
		display.setVerticalGroup(
				display.createSequentialGroup()
				.addComponent(foundIntroJLabel)
				.addComponent(foundAccountJLabel)
				.addComponent(searchAgainButton)
				);
		}
		
		add(displayPane);
		displayPane.setVisible(false);
		
	}
	
	private void notFoundPane() {
		notFoundPane = new JPanel();
		GroupLayout notFound = new GroupLayout(notFoundPane);
		notFoundPane.setLayout(notFound);
		notFoundPane.setOpaque(false);
		
			notFoundJLabel = new JLabel("Sorry, we couldn't find an account with that number");
			notFoundJLabel.setFont(allLabels);
			notFoundJLabel.setForeground(lGreenColor);		
			
		notFound.setHorizontalGroup(
				notFound.createSequentialGroup()
				.addGroup(notFound.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(notFoundJLabel)
						.addComponent(searchAgainButton)
						));
		
		notFound.setVerticalGroup(
				notFound.createSequentialGroup()
					.addComponent(notFoundJLabel)
					.addComponent(searchAgainButton)
					);
			
			add(notFoundPane);
			notFoundPane.setVisible(false);
		}

	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==findAccountButton) {
				accNum = selectAccount.getText();
				
				try {
				Long accNumToFind = Long.parseLong(accNum);
				
				foundAccount = Bank.searchAccounts(accNumToFind);
				
				} 
				catch (NumberFormatException notLong) {
					errorMsg.setVisible(true);
				}
				
				if(foundAccount==null) {
					notFoundPane.setVisible(true);
					displayPane.setVisible(false);
					selectionPane.setVisible(false);
				} else {
					displayPane.setVisible(true);
					notFoundPane.setVisible(false);
					selectionPane.setVisible(false);
				}
			}
			else {
			displayPane.setVisible(false);
			notFoundPane.setVisible(false);
			selectionPane.setVisible(true);
			}
		}
		
	}
	
	private class BadInputHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String accNum = selectAccount.getText();
			try {
				Integer.parseInt(accNum);
				findAccountButton.setEnabled(true);
				errorMsg.setVisible(false);
			} catch (Exception notInt){
				errorMsg.setVisible(true);
			}
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); //set background
	}

}