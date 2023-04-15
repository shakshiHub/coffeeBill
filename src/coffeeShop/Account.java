package coffeeShop;

public class Account { // Account objects, used in coffeeBill class to store registeredAccounts in
						// array of Accounts

	String name;
	String ID;
	double accountBalance;

	public Account(String name, String ID, double accountBalance) {
		this.name = name;
		this.ID = ID;
		this.accountBalance = accountBalance;
	}
}
