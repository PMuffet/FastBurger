package fastBurgerCLI;

import java.util.Scanner;

public class FastBurger {

	private double amountPaid;
	private double totalOrderCost;
	private int totalOrderTime;
	private int burgersBought;
	private int friesBought;
	private int sodasBought;
	private int mealsBought;

	Scanner console = new Scanner(System.in);

	// Objects of other classes for accessing/mutating variables stored in those classes

	Report R1 = new Report();
	Burger B1 = new Burger();
	Fries F1 = new Fries();
	Soda S1 = new Soda();

	// Main Menu
	public void runApp() {

		// reset sales from previous order
		setBurgersBought(0);
		setFriesBought(0);
		setSodasBought(0);
		setMealsBought(0);

		System.out.println("======================================================" + "\nFast Burger"
				+ "\n======================================================");
		System.out.println("1) order" + "\n2) Show sales report" + "\n3) Update prices" + "\n4) Exit");

		System.out.print("Enter your choice: ");

		switch (console.nextInt()) {
		case 1:
			System.out.println("Order Menu");
			orderFood();
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

	public void showSalesReport() {

		R1.generateSalesReport();

	}

	// Below is the update Price menu. All Prices are displayed first for reference.
	// Each method displays the current price then takes user
	// input to update the respective double.
	// User has the option to exit to main menu without updating price.
	public void updatePrices() {
		System.out.println("Current Prices: " + "\nBurger: $" + B1.getBurgerPrice() + "\nFries: $" + F1.getFriesPrice()
				+ "\nSoda: $" + S1.getSodaPrice());
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
		System.out.println("Current Burger Price is: " + B1.getBurgerPrice() + "\nEnter New Price:");
		B1.setBurgerPrice(console.nextDouble());
		System.out.println("New Burger Price is: " + B1.getBurgerPrice());

	}

	public void updateFriesPrice() {
		System.out.println("Current Fries Price is: " + F1.getFriesPrice() + "\nEnter New Price:");
		F1.setFriesPrice(console.nextDouble());
		System.out.println("New Fries Price is: " + F1.getFriesPrice());

	}

	public void updateSodaPrice() {
		System.out.println("Current Soda Price is: " + S1.getSodaPrice() + "\nEnter New Price:");
		S1.setSodaPrice(console.nextDouble());
		System.out.println("New Soda Price is: " + S1.getSodaPrice());

	}

	// Below is the order Menu

	public void orderFood() {
		System.out.println("Please select from the following food options: ");
		System.out.println("1) Burger" + "\n2) Fries" + "\n3) Soda" + "\n4) Meal" + "\n5) End Order");
		switch (console.nextInt()) {
		case 1:
			orderBurger();

			break;
		case 2:
			orderFries();

			break;
		case 3:
			orderSoda();
			break;
		case 4:
			orderMeal();
			break;
		case 5:
			System.out.println("End Order");
			break;
		default:
			System.err.println("Unrecognized option");
			// unrecognizedMenu
			break;
		}

	}

	// Below is the method for ordering burgers which keeps track of total number of
	// items
	public void orderBurger() {
		System.out.println("How many burgers would you like to buy:  ");
		setBurgersBought(console.nextInt());
		totalOrderTime = burgersBought * 9;
		System.out.println(
				"You have ordered " + getBurgersBought() + " burgers - would you like to order anything else?");
		R1.setTotalSales(R1.getTotalSales() + getBurgersBought() * B1.getBurgerPrice());

		System.out.println("1) Yes \n2) No");
		switch (console.nextInt()) {
		case 1:
			System.out.println("ordering more food");
			orderFood();

			break;
		case 2:
			finaliseOrder();

			break;
		default:
			System.err.println("Unrecognized option");
			// unrecognizedMenu
			break;

		}

	}

	// fries ordering menu
	public void orderFries() {
		System.out.println("How many Fries would you like to buy:  ");
		setFriesBought(console.nextInt());
		if (getFriesBought() > F1.getFriesInTray()) {
			F1.setFriesInTray(F1.getFriesInTray() + 5);

			F1.setFriesInTray(F1.getFriesInTray() - getFriesBought());
			totalOrderTime = totalOrderTime + 8;
		}

		System.out.println("You have ordered " + getFriesBought() + " Fries - would you like to order anything else?");
		R1.setTotalSales(R1.getTotalSales() + getFriesBought() * F1.getFriesPrice());

		System.out.println("1) Yes \n2) No");
		switch (console.nextInt()) {
		case 1:
			System.out.println("ordering more food");
			orderFood();

			break;
		case 2:
			finaliseOrder();

			break;
		default:
			System.err.println("Unrecognized option");
			// unrecognizedMenu
			break;

		}
	}

//soda ordering menu
	public void orderSoda() {
		System.out.println("How many Sodas would you like to buy:  ");
		setSodasBought(console.nextInt());

		System.out.println("You have ordered " + getSodasBought() + " Sodas - would you like to order anything else?");
		R1.setTotalSales(R1.getTotalSales() + getSodasBought() * S1.getSodaPrice());

		System.out.println("1) Yes \n2) No");
		switch (console.nextInt()) {
		case 1:
			System.out.println("ordering more food");
			orderFood();

			break;
		case 2:
			finaliseOrder();

			break;
		default:
			System.err.println("Unrecognized option");
			// unrecognizedMenu
			break;

		}

	}

	// meal ordering menu 
	//increments sales of all other items and calculates cost as the others combined followed by subtracting 3
	public void orderMeal() {
		setMealsBought(mealsBought++);

		System.out.println("You have ordered a meal would you like to order anything else?");
		R1.setTotalSales(R1.getTotalSales() + B1.getBurgerPrice() + S1.getSodaPrice() + (F1.getFriesPrice() - 3));
		setBurgersBought(getBurgersBought() + 1);
		setFriesBought(getFriesBought() + 1);
		setSodasBought(getSodasBought() + 1);
		setTotalOrderCost(getTotalOrderCost() - 3);

		System.out.println("1) Yes \n2) No");
		switch (console.nextInt()) {
		case 1:
			System.out.println("ordering more food");
			orderFood();

			break;
		case 2:
			finaliseOrder();

			break;
		default:
			System.err.println("Unrecognized option");
			// unrecognizedMenu
			break;

		}

	}

	// method for finalising and calculating full order
	
	public void finaliseOrder() {
		System.out.println("Total order: \nBurgers: " + getBurgersBought() + "\nFries: " + getFriesBought()
				+ "\nSodas: " + getSodasBought());
		System.out.println("Total Order time: " + totalOrderTime + " minutes");
		setTotalOrderCost((getBurgersBought() * B1.getBurgerPrice()) + (getFriesBought() * F1.getFriesPrice())
				+ (getSodasBought() * S1.getSodaPrice()));
		System.out.println("Total Cost: $" + getTotalOrderCost() + "\nEnter Amount to Pay");
		amountPaid = console.nextDouble();
		if (amountPaid < getTotalOrderCost()) {
			System.err.println("Insufficient funds");
		} else {
			System.out.println("Change to customer = $" + (amountPaid - getTotalOrderCost()));

		}

	}

	// accessors and mutators

	public int getBurgersBought() {
		return burgersBought;
	}

	public void setBurgersBought(int burgersBought) {
		this.burgersBought = burgersBought;
	}

	public int getFriesBought() {
		return friesBought;
	}

	public void setFriesBought(int friesBought) {
		this.friesBought = friesBought;
	}

	public int getSodasBought() {
		return sodasBought;
	}

	public void setSodasBought(int sodasBought) {
		this.sodasBought = sodasBought;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getMealsBought() {
		return mealsBought;
	}

	public void setMealsBought(int mealsBought) {
		this.mealsBought = mealsBought;
	}

	public double getTotalOrderCost() {
		return totalOrderCost;
	}

	public void setTotalOrderCost(double totalOrderCost) {
		this.totalOrderCost = totalOrderCost;
	}

}
