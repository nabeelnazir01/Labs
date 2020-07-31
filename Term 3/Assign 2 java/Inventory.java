import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Comparator;

public class Inventory implements Comparator<FoodItem> {
    private ArrayList<FoodItem> inventory = new ArrayList<FoodItem>();

    /**
     * Default constructor for Inventory
     */
    public Inventory() {
        inventory = new ArrayList<FoodItem>(20);
    }

    /**
     * @return String value of all foods in inventory
     */
    public String toString() {
        String foods = "";
        for (int i = 0; i < inventory.size(); i++) {
            foods += "\n" + inventory.get(i);
        }
        return "Inventory:" + foods;
    }

    /**
     * Finds FoodItem that has same item code as the one passed through. If not
     * found it will return -1.
     * 
     * @param item FoodItem being located
     * @return int which is position of food item that has same item code
     */
    public int alreadyExists(FoodItem item) {
        int position = -1;
        for (int i = 0; i < inventory.size(); i++) {
            if (item.itemCode == (inventory.get(i).itemCode) && i > 0) {
                position = i;
            }
        }
        return position;
    }

    /**
     * Makes a new object for food item type and checks if already exists and then
     * uses addItem food method to add new item.
     * 
     * @param scanner user input
     * @param fromFile if using file or not
     * @return boolean if it was successful
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (fromFile) {
            String type = scanner.nextLine();
            // Checks which type of FoodItem
            if (type.equals("f"))
                inventory.add(0, new Fruit());
            else if (type.equals("v"))
                inventory.add(0, new Vegetable());
            else if (type.equals("p"))
                inventory.add(0, new Preserve());
            // Gets input code
            inventory.get(0).inputCode(scanner, true);
            // Checks if code exists
            if (alreadyExists(inventory.get(0)) != -1) {
                System.out.println("Item code already exists");
                inventory.remove(0);
                return false;
            }
            // Adds the rest of the values
            inventory.get(0).addItem(scanner, true);
        } else {
            System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
            String user = scanner.next();
            if (user.toUpperCase().equals("F"))
                inventory.add(0, new Fruit());
            else if (user.toUpperCase().equals("V"))
                inventory.add(0, new Vegetable());
            else if (user.toUpperCase().equals("P"))
                inventory.add(0, new Preserve());
            else {
                System.out.println("Invalid option!");
                this.addItem(scanner, false);
            }
            inventory.get(0).inputCode(scanner, false);
            if (alreadyExists(inventory.get(0)) != -1) {
                System.out.println("Item code already exists");
                inventory.remove(0);
                return false;
            }
            inventory.get(0).addItem(scanner, false);
        }
        inventory.sort(new Inventory());
        return true;
    }

    /**
     * Adds or subtracts from item quantity depending on buy and sell
     * 
     * @param scanner   reads user input
     * @param buyOrSell Will be true if buy, false if sell
     * @return boolean that says if it was successful or not
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
        int amount;
        if (inventory.size() == 0)
            return false;
        int code;
        System.out.println("Enter a code: ");
        try {
            code = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return false;
        }
        String word = buyOrSell ? "Buy" : "Sell";
        for (int i = 0; i < 0; i++) {
            if (inventory.get(i).itemCode == code) {
                System.out.println("Enter quantity to " + word + ": ");
                try {
                    amount = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    scanner.nextLine();
                    return false;
                }
                if (amount < 0) {
                    System.out.println("Invalid quantity...");
                    return false;
                } else if (buyOrSell)
                    return inventory.get(i).updateItem(amount);
                else
                    return inventory.get(i).updateItem(-amount);
            }
        }
        System.out.println("Code can not be found in inventory...");
        return false;
    }

    /**
     * Finds position of integer in array using binary search
     * 
     * @param l 1 of 2 integers to find middle of array.
     * @param r 1 of 2 integers to find middle of array.
     * @param x Number needed to be found.
     * @return Integer of position of value in array. Will return -1 if not found.
     */
    public int binarySearch(int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (inventory.get(mid).itemCode == x)
                return mid;
            if (inventory.get(mid).itemCode > x)
                return binarySearch(l, mid - 1, x);
            return binarySearch(mid + 1, r, x);
        }
        return -1;
    }

    /**
     * Compares objects in array list by field
     * 
     * @param o1 First compare object
     * @param o2 Second compare object
     * @return result
     */
    @Override
    public int compare(FoodItem o1, FoodItem o2) {
        if (o2.itemCode < o1.itemCode)
            return 1;
        if (o2.itemCode > o1.itemCode)
            return -1;
        return 0;
    }

    /**
     * Uses the binary search method to find a item with the same item code
     * 
     * @param scanner user input
     */
    public void searchForItem(Scanner scanner) {
        System.out.println("Type in code");
        // Uses binary search method to find position of item
        int result = binarySearch(0, inventory.size() - 1, scanner.nextInt());
        // Checks if found
        if (result == -1)
            System.out.println("Element not present");
        else
            // Prints item details
            System.out.println(inventory.get(result));
        scanner.nextLine();
    }

    /**
     * Reads all values from inventory and adds to file
     * 
     * @param scanner Scanner for reading file
     */
    public void saveToFile(Scanner scanner) {
        Formatter writer = null;
        try {
            System.out.println("Enter the filename to save to: ");
            File outputTextFile = new File(scanner.nextLine());
            writer = new Formatter(outputTextFile);
            for (FoodItem eachItem : inventory) {
                // Checks what type of FoodItem it is and adds corressponding letter to file
                if (eachItem instanceof Fruit) {
                    writer.format("%s", "f");
                } else if (eachItem instanceof Vegetable) {
                    writer.format("%s", "v");
                } else if (eachItem instanceof Preserve) {
                    writer.format("%s", "p");
                } else {
                    throw new InputMismatchException();
                }
                // Outputs the values to text file
                eachItem.outputItem(writer);
                writer.format("\n%s", "");
            }
            System.out.println("Saved file successfully");
        } catch (IOException x) {
            System.out.println("ERROR: An error occured");
        } catch (NumberFormatException x) {
            System.out.println("ERROR: Invalid text file");
        } catch (InputMismatchException x) {
            System.out.println("ERROR: Invalid text file");
        }
        try {
            writer.close();
        } catch (NullPointerException x) {
        }
    }

    /**
     * Reads all values from file and adds to inventory
     * 
     * @param sc Scanner for reading file
     */
    public void readFromFile(Scanner sc) {
        try {
            System.out.println("Enter the filename to read from: ");
            // Accesses file with file name from user
            File inputTextFile = new File(sc.nextLine());
            // Throw exception if file does not exists
            if (!inputTextFile.exists()) {
                throw new FileNotFoundException();
            }
            System.out.println("Reading from file...");
            Scanner reader = new Scanner(inputTextFile);
            // If text file empty print a error
            if (!reader.hasNextLine()) {
                System.out.println("ERROR: Empty text file");
                reader.close();
                return;
            }
            // Reads from text file until no more data
            while(reader.hasNextLine()) {
                if (!addItem(reader, true)) {
                    throw new InputMismatchException();
                }
            }
            System.out.println("Succesfully read inputs from file");
            return;
        } catch (FileNotFoundException x) {
            System.out.println("File Not Found, ignoring...");
        } catch (InputMismatchException x) {
            System.out.println("Error Encountered while reading the file, aborting...");
        }
    }
}