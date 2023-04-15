package coffeeShop;

import java.util.ArrayList;

public class coffeeBill {
	// coffeeBill class that keeps track of customer order, processes transaction of
	// the order, and either prints bill for customer or let's customer know of
	// declined transaction

	private ArrayList<String> itemsOrdered;
	private ArrayList<Integer> numOfItemsOrdered;
	private ArrayList<Double> individualOrderCosts;
	private String customerName;
	double totalCost = 0.00;
	private Account aAccount;

	private Account[] registeredAccounts = { new Account("Shakshi Sharma", "09123475", 400),
			new Account("Tom Johnson", "0914756", 30), new Account("Anna Pierece", "3281982", 10),
			new Account("Brady Turner", "7823732", 5) }; // array of registered accounts for taking payment for bill

	public coffeeBill(String customerName) {
		itemsOrdered = new ArrayList<>();
		numOfItemsOrdered = new ArrayList<>();
		individualOrderCosts = new ArrayList<>();
		this.customerName = customerName;
		for (int i = 0; i < registeredAccounts.length; i++) { // traverse through each account in array
			if (registeredAccounts[i].name.equals(customerName)) {// if u find account matching the person whose bill
																	// needs to be payed
				aAccount = registeredAccounts[i]; // aAccount set to specific person's account
			}
		}
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void order(String orderedItem, int numOfItems, String[] menu, double[] listedPrices) {
		itemsOrdered.add(orderedItem);// add item that is ordered to array
		numOfItemsOrdered.add(numOfItems);// add quantity of the same items ordered to array

		for (int i = 0; i < menu.length; i++) { // traverse through each menu item
			if (orderedItem.equalsIgnoreCase(menu[i])) { // once you find the menu item matching the customers ordered
															// item
				totalCost = totalCost + (listedPrices[i] * numOfItems); // calculate total cost after adding customers
																		// ordered items
				individualOrderCosts.add(listedPrices[i] * numOfItems); // calculate individual costs of the same
																		// ordered items
			}
		}
	}

	private boolean doTransaction() {
		if (aAccount.accountBalance >= totalCost) { // if customers account has enough money to cover total cost of meal
													// return true, else false
			return true;
		}
		return false;
	}

	public void printReceipt() {
		if (doTransaction()) { // if customer did have enough money to cover cost of meal, print receipt
			for (int i = 0; i < itemsOrdered.size(); i++) {
				System.out.println(numOfItemsOrdered.get(i) + " " + itemsOrdered.get(i) + " ($"
						+ individualOrderCosts.get(i) + ")");
			}
			System.out.println("--------------------");
			System.out.printf("Total: $%.2f", totalCost);

			System.out.println("\n");

			System.out.println("Customer Name: " + customerName);
			System.out.println("Thank You for Shopping with Us!");
		} else {
			System.out.println("Transaction Declined"); // if customer did not have enough money to cover costs of meal,
														// print that the transaction declined
		}
	}
}
