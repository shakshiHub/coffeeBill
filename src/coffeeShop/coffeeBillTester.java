package coffeeShop;

public class coffeeBillTester { // tester class

	public static void main(String[] args) {

		String[] coffeeAndBakery = { "latte", "cappuccino", "americano", "cold brew", "hot chocolate", "black coffee",
				"chocolate croissant", "muffin", "pesto sandwhich" };
		double[] prices = { 5.55, 4.45, 5.55, 5.65, 5.65, 3.55, 4.25, 4.15, 6.75 };

		coffeeBill bill = new coffeeBill("Shakshi Sharma"); // this account will have enough money to cover transaction,
															// so it should print receipt
		bill.order("latte", 3, coffeeAndBakery, prices);
		bill.order("Hot Chocolate", 1, coffeeAndBakery, prices);

		coffeeBill secondBill = new coffeeBill("Brady Turner"); // this account will not have enough money to cover
																// transaction, so it should say transaction declined
		secondBill.order("latte", 3, coffeeAndBakery, prices);
		secondBill.order("cappuccino", 1, coffeeAndBakery, prices);
		secondBill.order("Hot Chocolate", 1, coffeeAndBakery, prices);
		secondBill.order("muffin", 1, coffeeAndBakery, prices);

		System.out.println("FIRST TRIAL");
		System.out.println("Expected: \n3 latte ($16.65)\n" + "1 Hot Chocolate ($5.65)\n" + "--------------------\n"
				+ "Total: $22.30\n" + "\n" + "Customer Name: Shakshi Sharma\n" + "Thank You for Shopping with Us!\n");

		System.out.println("Results: ");
		bill.printReceipt();
		System.out.println("\n");

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("SECOND TRIAL");
		System.out.println("Expected: Transaction Declined");
		System.out.print("Results: ");
		secondBill.printReceipt();
	}
}
