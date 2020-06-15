import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
	 * Store the number of items currently in the numbers array.
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
	 * Adds a value in the numbers array
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
	}

	/**
	 * Adds values from numbers array to file
	 * @param name - Name of file that numbers are saved to
	 */
	public void addFile(String name) {
		try {
			Writer wr = new FileWriter(name);
			wr.write(String.valueOf(numItems));
			for (int i = 0; i < numItems; i++) {
				wr.write(String.valueOf("\n" + numbers[i]));
			}
			wr.close();
		} catch (IOException e) {
			System.out.println("Invalid file name");
		}
	}

	/**
	 * Adds multiple values to the array by calling addValue method
	 * 
	 * @param scan - Scanner object used for user input/file input
	 * @param number - Can store integer for amount of numbers added
	 */
	public void addValues(Scanner scan, int... number) {
		if (number.length == 0) {
			number = new int[1];
			number[0] = scan.nextInt();
		}
		int count = numItems;
		for (int i = 0; i < number[0] && i <= numbers.length-count; i++)
			addValue(scan);
	}

	/** 
	 * @return maximum value in the numbers array
	 */
	public float maxValue() {
		float max = numbers[0];
		for (int i = 0; i < numItems; i++) {
			max = max < numbers[i] ? numbers[i] : max;
		}
		return max;
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
	/** 
	 * @return all values in the array
	 */
	@Override
	public String toString() {
		String nums = "";
		for (int i = 0; i < numItems; i++) {
			nums += numbers[i] + "\n";
		}
		return nums;
	}

}
