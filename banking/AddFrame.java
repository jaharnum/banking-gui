package banking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddFrame extends JFrame {
	
	private JLabel addJLabel;
	private Color background;

	private JButton addButton;
	
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


	public AddFrame(){
		super("The " + Assign7.bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 10));
		
		background = new Color(13, 58, 40);
		addJLabel = new JLabel("Add Account", JLabel.CENTER);
		addJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		addJLabel.setForeground(lGoldColor);
		add(addJLabel);
		
		typePane();
		
		AddAccount add = new AddAccount();
		addButton = new JButton("Add Account");
		addButton.addActionListener(add);
		
	}
	
	private class AddAccount implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO check all fields needed have data, then create new account and add to bank account array
			
		}
	}
	private void typePane() {
		
		JLabel accTypeDesc;
		JRadioButton chequing;
		JRadioButton savings;
		ButtonGroup accountType;
		
		JPanel typePane = new JPanel(new BorderLayout());
		typePane.setOpaque(false);
		accTypeDesc = new JLabel("Select the account type:", JLabel.LEFT);
		accTypeDesc.setFont(new Font("Calibri", Font.PLAIN, 16));
		accTypeDesc.setForeground(lGreenColor);
		typePane.add(accTypeDesc, BorderLayout.WEST);
		
		TypeHandler accType = new TypeHandler();
		
		chequing = new JRadioButton("Chequing", false);
		typePane.add(chequing, BorderLayout.CENTER);
		chequing.addActionListener(accType);
		//TODO secondary action listener for adding the account
		
		savings = new JRadioButton("Savings", false);
		typePane.add(savings, BorderLayout.EAST);
		savings.addActionListener(accType);
		//add account action listener
		
		accountType = new ButtonGroup();
		accountType.add(chequing);
		accountType.add(savings);
		
		add(typePane);
				
	}
	
	private void infoPane() {
		
		JTextField fName;
		JTextField lName;
		JLabel nameJLabel;
		
		JTextField phoneNum;
		JLabel phoneJLabel;
		
		JTextField email;
		JLabel emailJLabel;
		
		JTextField balance;
		JLabel balanceJLabel;
		
		JTextField fee;
		JLabel feeJLabel;
		
		JTextField interest;
		JLabel interestJLabel;
		
		JTextField minBalance;
		JLabel minBalanceJLabel;
		
		JPanel infoPane = new JPanel();
		GroupLayout info = new GroupLayout(infoPane);
		infoPane.setLayout(info);
		infoPane.setOpaque(false);
		
		info.setAutoCreateGaps(true);
		info.setAutoCreateContainerGaps(true);
		
		info.setHorizontalGroup(
				info.createSequentialGroup() 
				//components that will be aligned horizonally go in the same group
					.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
					//group for jlabel components
					.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
					//group for jtextfield components
				
				);
		
		info.setVerticalGroup(
				
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
				//group for name fields
				
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
				//group for phone fields
				
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
				//group for email fields
				
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
				//group for balance fields
				
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
				//group for fee
				
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
				
				//group for interest rate
				
				.addGroup(info.createParallelGroup(GroupLayout.Alignment.LEADING))
				//group for min balance
				
				);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); //set background
	}
	
	private class TypeHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==chequing) {
				//fee text field should become usable
			}
			else if(e.getSource()==savings) {
				//interest rate and min balance should become usable
			} else {
				//they should both be unusable
				//is this possible tho if its after the event has happened?
			}
		}
	} //end typehandler
	
	private class BadInputHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//case for e.getSource() that will check input as the user clicks off the text field
			
		}
	}

}
