package banking;

import java.util.Scanner; //best practice: only import the specific classes you actually will be using rather than java.util.*

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Assign7 {

	public static Scanner in = new Scanner(System.in);
	static Bank bank = new Bank("JH");

	public static void displayMenu() {
		
		/* System.out.println("Enter your choice:");
		System.out.println("a: Add new account");
		System.out.println("d: Display account details");
		System.out.println("p: Print all accounts");
		System.out.println("u: Update account balance");
		System.out.println("m: Month-end update");
		System.out.println("q: Quit");
		*/
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			BankFrame menu = new BankFrame();
			menu.setSize(400, 600);
			menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			menu.setVisible(true);
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}

	}
	
	public static void main(String[] args) {
		
		char option = 'x';
		
		do {
			
			displayMenu();
			
			option = in.next().toLowerCase().charAt(0); //method chaining - convert to lowercase, consider only first character
			
			switch(option) {
			
			case 'a':
				bank.addAccount();
				break;
				
			case 'd':
				bank.displayAccount();
				break;
				
			case 'p':
				bank.printAccountDetails();
				
			case 'u':
				bank.updateAccount();
				break;
				
			case 'm':
				bank.monthlyUpdate();
				break;
				
			case 'q': 
				break;
				
			default:
				System.out.println("I'm sorry, I didn't understand your choice. Please try again");
			}
			
		} while (option !='q');
		
		in.close();
		System.out.println("Have a nice day!");

	}

}
