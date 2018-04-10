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

public class AddFrame extends JFrame {
	
	private JLabel addJLabel;
	
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


	public AddFrame(){
		super("The " + Assign7.bank.getName() + " Banking System");
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 30));
		
		background = new Color(13, 58, 40);
		addJLabel = new JLabel("Add Account", JLabel.CENTER);
		addJLabel.setFont(new Font("Serif", Font.BOLD, 45));
		addJLabel.setForeground(lGoldColor);
		
		
		add(addJLabel);

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); //set background
	}

}