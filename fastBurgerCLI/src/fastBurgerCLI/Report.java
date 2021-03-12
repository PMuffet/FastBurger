package fastBurgerCLI;

import java.util.Scanner;

public class Report {

	private double TotalSales = 0;

	Scanner console = new Scanner(System.in);

	// Sales Report method - Uses value from FastBurger classes and prints it
	// essentially

	public void generateSalesReport() {

		System.out.println("1) Generate Daily Sales Report" + "\n2) Return to Main Menu");

		System.out.print("Enter your choice: ");

		switch (console.nextInt()) {
		case 1:
			System.out.println("Generating Sales Report");
			System.out.println("Total sales for today: $" + TotalSales);
			System.out.println("Returning to Main Menu...");
			break;
		case 2:
			System.out.println("Returning to Main Menu...");
			break;

		default:
			System.err.println("Unrecognized option");
			generateSalesReport();
			// unrecognizedMenu();
			break;
		}

	}

	public double getTotalSales() {
		return TotalSales;
	}

	public void setTotalSales(double totalSales) {
		TotalSales = totalSales;
	}

}
