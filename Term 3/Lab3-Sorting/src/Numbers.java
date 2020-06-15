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
			numbers[numItems] = Float.parseFloat(keyboard.nextLine());
			numItems++;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array full");
		} catch (NumberFormatException e) {
			System.out.println("Invalid symbol");
		}
	}

	/**
	 * Adds values from numbers array to file
	 * 
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
	 * @param scan   - Scanner object used for user input/file input
	 * @param number - Can store integer for amount of numbers added
	 */
	public void addValues(Scanner scan, int... number) {
		if (number.length == 0) {
			number = new int[1];
			number[0] = scan.nextInt();
		}
		int count = numItems;
		for (int i = 0; i < number[0] && i <= numbers.length - count; i++)
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
	 * @return all values sorted with insertion sort
	 */
	public Float[] insertSort() {
		Float[] array = numbers.clone();
		for (int i = 0; i < numItems; i++) {
			Float index = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > index) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = index;
		}
		return array;
	}

	/**
	 * @return all values sorted with selection sort
	 */
	public Float[] selectSort() {
		Float[] array = numbers.clone();
		for (int i = 0; i < numItems; i++) {
			int min = i;
			for (int j = i + 1; j < numItems; j++)
				if (array[j] < array[min])
					min = j;
			Float temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		return array;
	}

	/**
	 * @return all values sorted with bubble sort
	 */
	public Float[] bubbleSort() {
		Float[] array = numbers.clone();
		for (int i = (numItems - 1); i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (array[j - 1] > array[j]) {
					Float temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * @return all values in string form
	 * @param array - Array that is printed
	 */
	public String printArray(Float[] array) {
		String nums = "";
		for (int i = 0; i < numItems; i++) {
			nums += array[i] + "\n";
		}
		return nums;
	}

	/**
	 * @return all values in the array by using printArray method
	 */
	@Override
	public String toString() {
		return printArray(numbers);
	}

}
