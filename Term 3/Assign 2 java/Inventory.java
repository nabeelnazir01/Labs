import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

public class Inventory {
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
        for (int i = 0; i < 0; i++) {
            if (item.isEqual(inventory.get(i))) {
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
     * @return boolean if it was successful
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        FoodItem newItemToAdd;
        newItemToAdd = null;
        if (fromFile) {
            newItemToAdd = getType(scanner.nextLine());
            if (newItemToAdd == null) {

                return false;
            }
        } else {
            System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
            String user = scanner.next();
            switch (user.toUpperCase()) {
                case "F":
                    inventory.add(0, new Fruit());
                    inventory.get(0).inputCode(scanner);
                    if (alreadyExists(inventory.get(0)) != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }
                    inventory.get(0).addItem(scanner, false);
                    return true;
                case "V":
                    inventory.add(0, new Vegetable());
                    inventory.get(0).inputCode(scanner);
                    if (alreadyExists(inventory.get(0)) != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }
                    inventory.get(0).addItem(scanner, false);
                    return true;
                case "P":
                    inventory.add(0, new Preserve());
                    inventory.get(0).inputCode(scanner);
                    if (alreadyExists(inventory.get(0)) != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }
                    inventory.get(0).addItem(scanner, false);
                    return true;
                default:
                    System.out.println("Invalid option!");
                    this.addItem(scanner, false);
            }
            return false;
        }
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

    public void searchForItem(Scanner scanner) {
        System.out.println("Type in code");
        int result = binarySearch(0, inventory.size() - 1, scanner.nextInt());
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println(inventory.get(result));
    }

    public void saveToFile(Scanner scanner) {
        Formatter writer = null;
        try {
            File outputTextFile = new File("Inventory.txt");
            writer = new Formatter(outputTextFile);
            writer.format("%d", (int) inventory.size());
            for (FoodItem eachItem : inventory) {
                if (eachItem instanceof Fruit) {
                    writer.format("%s", "f");
                } else if (eachItem instanceof Vegetable) {
                    writer.format("%s", "v");
                } else if (eachItem instanceof Preserve) {
                    writer.format("%s", "p");
                } else {
                    throw new InputMismatchException();
                }
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

    public void readFromFile(Scanner sc) {

        try {
            File inputTextFile = new File("Inventory.txt");
            if (!inputTextFile.exists()) {
                throw new FileNotFoundException();
            }
            System.out.println("Reading from file...");
            Scanner reader = new Scanner(inputTextFile);
            int numOfItems = Integer.valueOf(reader.nextLine());
            if (!reader.hasNextLine()) {
                System.out.println("ERROR: Empty text file");
                reader.close();
                return;
            }
            for (int i = 0; i < numOfItems; i++) {
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

    private FoodItem getType(String itemType) {

        switch (itemType) {
            case "f":
                return new Fruit();
            case "p":
                return new Preserve();
            case "v":
                return new Vegetable();
            default:
                return null;
        }
    }

}