package banking;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * PrintFrame prints all of the currently created accounts.
 * 
 * @author Jamie Harnum
 * @see BankAccount
 */
public class PrintFrame extends JFrame {

	private JLabel printJLabel;
	private JPanel printPane;
	private JButton exitJButton;
	private Color background;

	private Color lGoldColor = new Color(245, 212, 100);

	/**
	 * Sets the components for the PrintFrame
	 */
	public PrintFrame() {
		super("The " + Assign7.bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 30));

		background = new Color(13, 58, 40);
		printJLabel = new JLabel("All " + Assign7.bank.getNumAccounts() + " Accounts", JLabel.CENTER);
		printJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		printJLabel.setForeground(lGoldColor);

		exitJButton = new JButton("Exit");
		exitJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}// end actionperformed
		});

		add(printJLabel);
		printPane();
		add(exitJButton);

	}

	/**
	 * The printPane contains the JTextArea that actually displays the account information
	 */
	public void printPane() {
		printPane = new JPanel();
		printPane.setOpaque(true);
		JTextArea allAccounts = new JTextArea(5, 5);
		JScrollPane scrollPane = new JScrollPane(allAccounts);
		allAccounts.setEditable(false);
		allAccounts.setFont(new Font("Calibri", Font.PLAIN, 20));

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		ArrayList<String> allAccountText = new ArrayList<String>();

		for (BankAccount acc : Bank.accounts) {
			String displayAcc = acc.toString() + "\n";
			allAccountText.add(displayAcc);
			JLabel lineBreak = new JLabel("<html><br><br></html>");
			printPane.add(lineBreak);
			printPane.repaint();
		}

		allAccounts.setText(allAccountText.toString());
		printPane.add(allAccounts);
		add(printPane);
	}

	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); // set background
	}

}
