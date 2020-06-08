import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Nabeel Nazir Student Number: 040974403 Course: CST8130 - Data
 * Structures : CET-CS-Level 3
 * 
 * @author/Professor James Mwangi PhD.
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */

public class Lab2 {

	/**
	 *  Displays main menu for user to pick from
	 */
	public static void displayMainMenu() {
		System.out.println("Please select one of the following:\n1: Initialize a default array\n"
				+ "2: To specify the max size of the array\n3: Add value to the array\n"
				+ "4: Display values in the array\n5: Display the average of the values and max value\n6: Enter multiple values\n"
				+ "7: Read values from file\n8: Save values to file\n9: To Exit");
	}

	/**
	 * Main method with choice handling
	 * @param args
	 */
	public static void main(String[] args) {
		Numbers numbers = new Numbers();
		Scanner scan = new Scanner(System.in);
		String user = "";
		while (!user.equals("9")) {
			displayMainMenu();
			user = scan.nextLine();
			switch (user) {
				case "1":
					numbers = new Numbers();
					break;
				case "2":
					System.out.print("Enter new size of array: ");
					numbers = new Numbers(scan.nextInt());
					scan.nextLine();
					break;
				case "3":
					System.out.print("Enter value: ");
					numbers.addValue(scan);
					scan.nextLine();
					break;
				case "4":
					System.out.println("Numbers are:\n" + numbers);
					break;
				case "5":
					System.out.println("Average is: " + numbers.calcAverage()+"\nMax is: " + numbers.maxValue());
					break;
				case "6":
					System.out.println("How many values do you wish to add? ");
					numbers.addValues(scan, scan.nextInt());
					scan.nextLine();
					break;
				case "7":
					System.out.println("Name of the file to read from: ");
					try {
						numbers.addValues(new Scanner(new File(scan.nextLine())));
					} catch (FileNotFoundException e) {
						System.out.println("File not found");
					}
					break;
				case "8":
					System.out.println("Name of the file to save to: ");
					numbers.addFile(scan.nextLine());
					break;
				case "9":
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid option!");
			}
		}
	}

}
