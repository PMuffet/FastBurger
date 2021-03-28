package fastBurgerCLI;

import java.util.Scanner;

public class Report {

	private double totalSales = 0;

	Scanner console = new Scanner(System.in);

	// Sales Report method - Uses value which is set by FastBurger class and prints it 
	// essentially

	public void generateSalesReport() {

		System.out.println("1) Generate Daily Sales Report" + "\n2) Return to Main Menu");

		System.out.print("Enter your choice: ");

		switch (console.nextInt()) {
		case 1:
			System.out.println("Generating Sales Report");
			System.out.println("Total sales for today: $" + totalSales);
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
		return totalSales;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}

}
