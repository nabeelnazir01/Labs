import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Student Number: Course: CST8130 - Data Structures :
 * CET-CS-Level 3
 * 
 * @author/Professor James Mwangi PhD.
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float[] numbers;

	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		this(20);
	}

	/**
	 * Constructor that initializes the numbers array.
	 * 
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		numbers = new Float[size];
		numItems = 0;
	}

	/**
	 * Adds a value in the array
	 * 
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		try {
			numbers[numItems] = keyboard.nextFloat();
			numItems++;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array full");
		} catch (InputMismatchException e) {
			System.out.println("Invalid symbol");
		}
		keyboard.nextLine();
	}

	/**
	 * Calculates the average of all the values in the numbers array.
	 * 
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		float addedValues = 0;
		if (numItems > 0) {
			for (int i = 0; i < numItems; i++) {
				addedValues += numbers[i];
			}
			return addedValues / numItems;
		}
		return 0.0f;
	}

	@Override
	public String toString() {
		String nums = "";
		for (int i = 0; i < numItems; i++) {
			nums += numbers[i] + "\n";
		}
		return nums;
	}

}
