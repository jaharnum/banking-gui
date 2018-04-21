package banking;

/**
 * The Person class holds the information associated with the account holder
 * 
 * @author Jamie Harnum
 * @see BankAccount
 */
public class Person {

	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String email;

	public Person(String firstName, String lastName, long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String toString() {
		return "Name: " + getName() + " | Phone: " + phoneNumber + " | Email: " + email;
	}
}
