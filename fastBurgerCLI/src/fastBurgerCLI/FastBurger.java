package fastBurgerCLI;

import java.util.Scanner;

public class FastBurger {

	private double BurgerPrice = 7.0;
	private double FriesPrice = 4.0;
	private double SodaPrice = 2.50;
	private boolean FriesInTray;
	private double AmountPaid;

	Scanner console = new Scanner(System.in);

	// Objects of other classes

	Report R1 = new Report();

	// Main Menu
	public void runApp() {
		System.out.println("======================================================" + "\nFast Burger"
				+ "\n======================================================");
		System.out.println("1) order" + "\n2) Show sales report" + "\n3) Update prices" + "\n4) Exit");

		System.out.print("Enter your choice: ");

		switch (console.nextInt()) {
		case 1:
			System.out.println("Order Menu");
			orderMenu();
			break;
		case 2:
			System.out.println("Sales Report Display");
			showSalesReport();
			break;
		case 3:
			System.out.println("Update Price Menu");
			updatePrices();
			break;
		case 4:
			System.err.println("Application Terminated");
			System.exit(0);
			break;
		default:
			System.err.println("Unrecognized option");

			// unrecognizedMenu();
			break;
		}
		runApp();
	}

	// Main Menu Methods

	public void orderMenu() {

	}

	public void showSalesReport() {

		R1.generateSalesReport();

	}

	// Below is the update Price menu. All Prices are displayed first for reference.
	// Each method displays the current price then takes user
	// input to update the respective double.
	// User has the option to exit to main menu without updating price.
	public void updatePrices() {
		System.out.println(
				"Current Prices: " + "\nBurger: $" + BurgerPrice + "\nFries: $" + FriesPrice + "\nSoda: $" + SodaPrice);
		System.out.println("What item would you like to update?");
		System.out.println("1) Update Burger Price" + "\n2) Update Fries Price" + "\n3) Update Soda Price"
				+ "\n4) Return to Main Menu");
		switch (console.nextInt()) {
		case 1:
			System.out.println("Update Burger Price");
			updateBurgerPrice();
			break;
		case 2:
			System.out.println("Update Fries Price");
			updateFriesPrice();
			break;
		case 3:
			System.out.println("Update Soda Price");
			updateSodaPrice();
			break;
		case 4:
			System.out.println("Return to Main Menu");
			break;
		default:
			System.err.println("Unrecognized option");
			// unrecognizedMenu
			break;
		}

	}

	public void updateBurgerPrice() {
		System.out.println("Current Burger Price is: " + BurgerPrice + "\nEnter New Price:");
		setBurgerPrice(console.nextDouble());
		System.out.println("New Burger Price is: " + BurgerPrice);

	}

	public void updateFriesPrice() {
		System.out.println("Current Fries Price is: " + FriesPrice + "\nEnter New Price:");
		setFriesPrice(console.nextDouble());
		System.out.println("New Fries Price is: " + FriesPrice);

	}

	public void updateSodaPrice() {
		System.out.println("Current Soda Price is: " + SodaPrice + "\nEnter New Price:");
		setSodaPrice(console.nextDouble());
		System.out.println("New Soda Price is: " + SodaPrice);

	}

	// Accessors and Mutators

	public double getBurgerPrice() {
		return BurgerPrice;
	}

	public void setBurgerPrice(double burgerPrice) {
		BurgerPrice = burgerPrice;
	}

	public double getFriesPrice() {
		return FriesPrice;
	}

	public void setFriesPrice(double friesPrice) {
		FriesPrice = friesPrice;
	}

	public double getSodaPrice() {
		return SodaPrice;
	}

	public void setSodaPrice(double sodaPrice) {
		SodaPrice = sodaPrice;
	}

	public boolean isFriesInTray() {
		return FriesInTray;
	}

	public void setFriesInTray(boolean friesInTray) {
		FriesInTray = friesInTray;
	}

}
