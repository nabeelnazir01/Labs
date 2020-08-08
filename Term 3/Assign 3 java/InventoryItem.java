import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The purpose of this class is to add some functionality to the inventory class
 * with adding support for expired foods. farm supplier by calling super()
 * 
 * @author Justin Warkus-Fortin (040966794) Assignment 3 August 5th 2020
 * @version 1.0
 * @since 1.8
 */
public class InventoryItem implements Comparable<InventoryItem>, Iterator<LocalDate> {
	protected int itemQuantityInStock;
	private FoodItem foodItem;
	private LinkedList<LocalDate> expiries;

	public InventoryItem(FoodItem foodItem) {
		this.itemQuantityInStock = 0;
		this.foodItem = foodItem;
		this.expiries = new LinkedList<>();
	}

	public int getItemCode() {
		return foodItem.getItemCode();
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public LocalDate next() {
		return null;
	}
	
	@Override
	public int compareTo(InventoryItem itemCompare) {
		return (this.foodItem.itemCode - itemCompare.getItemCode());
	}

	/**
	 * Adds item details to the item
	 * 
	 * @param scan Scanner for user input
	 * @return boolean to check if worked
	 */
	public boolean addItem(Scanner scan) {
		foodItem.addItem(scan);
		Pattern pattern = Pattern.compile("^\\d+");
		// Pattern that doesn't allow any negative numbers
		System.out.print("Enter quantity for the item: ");
		String strQuant = scan.next();
		while (!pattern.matcher(strQuant).matches()) {
			System.out.println("Invalid input");
			System.out.print("Enter quantity for the item: ");
			strQuant = scan.next();
		}
		this.itemQuantityInStock = Integer.parseInt(strQuant);
		System.out.print("Enter the expiry date of the item (yyyy-mm-dd or none): ");
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = scan.next();
			if (date.contentEquals("none") || date.contentEquals("None")) {
				for (int i = 0; i < itemQuantityInStock; i++) {
					expiries.add(LocalDate.MAX);
				}
			} else {
				for (int i = 0; i < itemQuantityInStock; i++) {
					expiries.add(LocalDate.parse(date, format));
				}
			}
		} catch (DateTimeParseException e) {
			System.out.println("Could not create date from input, please use format yyyy-mm-dd\n" + e.getMessage());
		}
		scan.nextLine();
		return true;
	}

	public boolean inputCode(Scanner scan) {
		return foodItem.inputCode(scan);
	}

	/**
	 * Prints expired items
	 */
	public void printExpiry() {
		ListIterator<LocalDate> lDIterator = expiries.listIterator();
		LocalDate ld = expiries.peek();
		int count = 0;
		System.out.println(this.toString());
		System.out.println("Expiry Details:");
		while (lDIterator.hasNext()) {
			LocalDate current = lDIterator.next();
			if (ld.compareTo(current) == 0) {
				count++;
			} else {
				System.out.println(ld + " : " + count);
				ld = current;
				count = 1;
			}
			if (current == expiries.peekLast()) {
				System.out.println(ld + " : " + count);
			}
		}
	}

	/**
	 * Removes all expired items based off of current date
	 * 
	 * @param today The current date
	 */
	public void removeExpiredItems(LocalDate today) {
		ListIterator<LocalDate> ldItr = expiries.listIterator();
		while (ldItr.hasNext()) {
			if (today.compareTo(ldItr.next()) > 0) {
				ldItr.remove();
				itemQuantityInStock--;
			}
		}
	}

	/**
	 * Allows user to buy or sell items
	 * 
	 * @param scan   Scanner for user input
	 * @param amount Amount to buy or sell
	 * @return boolean to check if worked
	 */
	public boolean updateQuantity(Scanner scan, int amount) {
		if ((this.itemQuantityInStock + amount) < 0) { // (itemQuantity+(-amount))can never be less than 0
			return false;
		} else { // buy or sell
			if (amount < 0) { // sell
				// remove amount from queue
				for (int i = 0; i < (-amount); i++) {
					expiries.poll();// remove the item
					this.itemQuantityInStock--;
				}
			} else {
				// buying amount
				boolean exit = false;
				while (!exit) {
					System.out.println("Enter the expiry date of the item (yyyy-mm-dd or none):");
					String date = scan.nextLine();
					for (int i = 0; i < amount; i++) {
						try {
							LocalDate tempObj = LocalDate.parse(date);
							this.expiries.add(tempObj);
							this.itemQuantityInStock++;
							exit = true;
						} catch (DateTimeParseException e) {
							System.out.println("Could not create date from input, please use format yyyy-mm-dd\n"
									+ e.getMessage());
							exit = false;
							break;
						}
					}
				}
			}
			return true;
		}
	}

	/**
	 * String value of item
	 */
	public String toString() {
		return foodItem.toString() + " qty: " + itemQuantityInStock;
	}

}
