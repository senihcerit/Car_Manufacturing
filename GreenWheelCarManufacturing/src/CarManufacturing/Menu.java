package CarManufacturing;

import java.util.List;
import java.util.Scanner;

public class Menu {

	static Scanner scan = new Scanner(System.in);
	public static List<Dealership> listOfDealerships;
	public static List<Car> listOfOldCars;
	public static List<Car> listOfNewCars;

	public Menu() {
		listOfDealerships = GreenWheelMainClass.listOfDealerships;
		listOfOldCars = GreenWheelMainClass.listOfOldCars;
		listOfNewCars = GreenWheelMainClass.listOfNewCars;
	}

	public void show() {

		System.out.println("Welcome to GreenWheel Manufacturing");

		while (true) {
			try {
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("(1) View all the existing products (old and new) - (without Details)");
				System.out.println("(2) View all the new products - (without Details)");
				System.out.println("(3) Select a single new product to view - (with Details)");
				System.out.println("(4) View all the dealerships and their products (Existing Stock and New Stock)");
				System.out.println("(5) Select a single dealership to view");
				System.out.println("(6) Select a product from a selected dealership");
				System.out.println("(7) Quit");
				System.out.println("-------------------------------------------------------------------------------");

				int choice = scan.nextInt();

				switch (choice) {
				case 1:
					viewAllExistingProducts();

					break;
				case 2:
					viewAllNewProducts();

					break;
				case 3:
					selectProductInDetail();

					break;
				case 4:
					viewAllDealershipsWithProducts();

					break;
				case 5:
					viewSelectedDealership();

					break;
				case 6:
					viewSelectedProductInSelectedDealership();

					break;
				case 7:
					// QUIT
					System.out.println("Would you like to close the programme?(Y/N)");
					String quitp = scan.next();
					if (quitp.equalsIgnoreCase("y")) {
						System.exit(0);
					}
					break;

				default:
					System.out.println("Invalid Number");

				}
			} catch (Exception ex) {
				System.out.println("ERROR");
			}

		}
	}

	private static void seperatorLine() {
		System.out.println("-------------------------------------------------------------------------------");
	}

	private static void viewSelectedProductInSelectedDealership() {
		seperatorLine();
		System.out.println("Dealerships:");
		for (int i = 0; i < listOfDealerships.size(); i++) {
			System.out.println((i + 1) + "- " + listOfDealerships.get(i).getName() + "'s GreenWheel Dealership");
		}

		System.out.println("Please enter the number of Dealership that you want to view products of it.");
		int select = scan.nextInt();

		try {
			System.out.println(listOfDealerships.get(select - 1).getName() + "'s Cars:");
			for (int j = 0; j < listOfDealerships.get(select - 1).getInventory().size(); j++) {
				System.out.println(
						(j + 1) + ") " + listOfDealerships.get(select - 1).getInventory().get(j).getCarNameAndVin());
			}
			System.out.println("Please enter the number of Car to see with details");
			int select2 = scan.nextInt();

			if (listOfDealerships.get(select - 1).getInventory().get(select2 - 1).getOldOrNew() == "NEW") {
				System.out
						.println(listOfDealerships.get(select - 1).getInventory().get(select2 - 1).toStringWithDonor());
			} else {
				System.out.println(listOfDealerships.get(select - 1).getInventory().get(select2 - 1).toString());
			}
		} catch (Exception ex) {
			System.out.println("Invalid Number");
		}

		seperatorLine();
	}

	private static void viewSelectedDealership() {
		seperatorLine();
		System.out.println("Dealerships:");
		for (int i = 0; i < listOfDealerships.size(); i++) {
			System.out.println((i + 1) + "- " + listOfDealerships.get(i).getName() + "'s GreenWheel Dealership");
		}
		System.out.println("Please enter the number of Dealership that you want to view:");
		int select = scan.nextInt();
		try {
			seperatorLine();
			System.out.println(listOfDealerships.get(select - 1).toStringWithStock());
			seperatorLine();

		} catch (Exception ex) {
			System.out.println("Invalid Number");
		}

	}

	private static void viewAllDealershipsWithProducts() {
		seperatorLine();
		for (int i = 0; i < listOfDealerships.size(); i++) {
			System.out.println(listOfDealerships.get(i).toStringWithStock());
			;
		}
		seperatorLine();
	}

	private static void selectProductInDetail() {
		seperatorLine();
		System.out.println("Enter 0 for Existing Products, 1 for New Products:");
		int selectedNumber = scan.nextInt();

		switch (selectedNumber) {
		case 0:
			System.out.println("Old Cars: ");
			for (int i = 0; i < listOfOldCars.size(); i++) {
				System.out.println((i + 1) + ") " + listOfOldCars.get(i).toLine());
			}

			System.out.println("Please enter the row number of Product");
			selectedNumber = scan.nextInt();

			if (selectedNumber > 0 && selectedNumber <= listOfOldCars.size()) {
				System.out.println(listOfOldCars.get((selectedNumber - 1)).toString());
			} else {
				System.out.println("Invalid Number");
			}

			break;
		case 1:
			System.out.println("New Cars: ");
			for (int i = 0; i < listOfNewCars.size(); i++) {
				System.out.println((i + 1) + ") " + listOfNewCars.get(i).toLine());
			}

			System.out.println("Please enter the row number of Product");
			selectedNumber = scan.nextInt();

			if (selectedNumber > 0 && selectedNumber <= listOfOldCars.size()) {
				System.out.println(listOfNewCars.get((selectedNumber - 1)).toStringWithDonor());
			} else {
				System.out.println("Invalid Number");
			}
			break;

		default:
			System.out.println("Invalid Number");
		}
		seperatorLine();
	}

	private static void viewAllExistingProducts() {
		viewAllOldProducts();
		viewAllNewProducts();
	}

	private static void viewAllOldProducts() {
		System.out.println("---------------------------------EXISTING CARS---------------------------------");
		for (int i = 0; i < listOfOldCars.size(); i++) {
			System.out.println((i + 1) + ") " + listOfOldCars.get(i).toLine());
		}
		seperatorLine();
	}

	private static void viewAllNewProducts() {
		System.out.println("-------------------------------------NEW CARS----------------------------------");
		for (int i = 0; i < listOfNewCars.size(); i++) {
			System.out.println((i + 1) + ") " + listOfNewCars.get(i).toLine());
		}
		seperatorLine();
	}
}
