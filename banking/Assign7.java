package banking;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Provides the main method and instantiates the main GUI frame for the banking system.<br>
 * This project was completed as a part of CST8132 for Dr. Anu Thomas.<br>
 * It serves as an exercise in using the java.swing package to build a GUI and in importing text files.<br>
 * The rest of the classes that comprise this project are:
 * <ul>
 * <li><code>Person
 * <li>Bank
 * <li>BankAccount
 * <li>SavingsAccount
 * <li>ChequingAccount
 * <li>BankFrame
 * <li>AddFrame
 * <li>DisplayFrame
 * <li>PrintFrame</code>
 * </ul>
 * @author Jamie Harnum
 * @version 3.0
 * 
 */
public class Assign7 {

	/**
	 * Instantiates the main Bank for the program, which is given the name JH
	 */
	protected static Bank bank = new Bank("JH");
	
	/**
	 * menu is the main BankFrame for the GUI
	 */
	protected static BankFrame menu;

	/**
	 * Instantiates and provides settings for the menu
	 * @see BankFrame
	 */
	public static void displayMenu() {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			menu = new BankFrame();
			menu.setSize(400, 700);
			menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			menu.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(menu, "Something went wrong", "Menu Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/*
	 * Main method that implements <code>displayMenu</code> and begins the program.
	 */
	public static void main(String[] args) {

		
		try {
			
			displayMenu();
		}
		catch (Exception e) {
			//TODO exception handling
		}
		

	}

}
