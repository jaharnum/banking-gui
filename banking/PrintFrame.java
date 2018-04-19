package banking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;


public class PrintFrame extends JFrame {
	
	private JLabel printJLabel;
	private JPanel printPane;
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
	private Color mGreenColor = new Color(35, 111, 80);


	public PrintFrame(){
		super("The " + Bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 30));
		
		background = new Color(13, 58, 40);
		printJLabel = new JLabel("All " + Assign7.bank.getNumAccounts() + " Accounts", JLabel.CENTER);
		printJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		printJLabel.setForeground(lGoldColor);

		exitJButton = new JButton("Exit");
		exitJButton.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}//end actionperformed
				});
		
		add(printJLabel);
		printPane();
		add(exitJButton);

	}
	
	public void printPane() {
		printPane = new JPanel();
		printPane.setOpaque(true);
		JLabel allAccounts = new JLabel();
		JScrollPane scrollPane = new JScrollPane(allAccounts);
		allAccounts.setFont(new Font("Calibri", Font.PLAIN, 20));
		allAccounts.setForeground(lGreenColor);
		
		scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		ArrayList<String> allAccountText = new ArrayList<String>();
		
			for(BankAccount acc : Assign7.bank.accounts) {
				String displayAcc = acc.toString() + "\n";
				allAccountText.add(displayAcc);
			}
			
		allAccounts.setText(allAccountText.toString());
		printPane.add(allAccounts);
		add(printPane);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); //set background
	}

}
