import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Inventory implements Comparator<InventoryItem> {
    private ArrayList<InventoryItem> inventory;

    /**
     * Default constructor for Inventory
     */
    public Inventory() {
        inventory = new ArrayList<InventoryItem>(20);
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
    public int alreadyExists(InventoryItem item) {
        int position = -1;
        for (int i = 0; i < inventory.size(); i++) {
            if (item.getItemCode() == (inventory.get(i).getItemCode()) && i > 0) {
                position = i;
            }
        }
        return position;
    }

    /**
     * Makes a new object for food item type and checks if already exists and then
     * uses addItem food method to add new item.
     * 
     * @param scanner  user input
     * @return boolean if it was successful
     */
    public boolean addItem(Scanner scanner) {
        System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
        String user = scanner.next();
        if (user.toUpperCase().equals("F"))
            inventory.add(0, new InventoryItem(new Fruit()));
        else if (user.toUpperCase().equals("V"))
            inventory.add(0, new InventoryItem(new Vegetable()));
        else if (user.toUpperCase().equals("P"))
            inventory.add(0, new InventoryItem(new Preserve()));
        else {
            System.out.println("Invalid option!");
            this.addItem(scanner);
        }
        inventory.get(0).inputCode(scanner);
        if (alreadyExists(inventory.get(0)) != -1) {
            System.out.println("Item code already exists");
            inventory.remove(0);
            return false;
        }
        inventory.get(0).addItem(scanner);
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
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemCode() == code) {
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
                    return inventory.get(i).updateQuantity(scanner, amount);
                else
                    return inventory.get(i).updateQuantity(scanner, -amount);
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
            if (inventory.get(mid).getItemCode() == x)
                return mid;
            if (inventory.get(mid).getItemCode() > x)
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
    public int compare(InventoryItem o1, InventoryItem o2) {
        if (o2.getItemCode() < o1.getItemCode())
            return 1;
        if (o2.getItemCode() > o1.getItemCode())
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

    public void removeExpired(LocalDate date) {
        for (int i = 0; i < inventory.size(); i++) {
            inventory.get(i).removeExpiredItems(date);
        }
    }

    /**
     * Prints all of the expired items
     * 
     * @param scan Scanner for user input
     * @return boolean to check if worked
     */
    public boolean printExpired(Scanner scan) {
        System.out.print("Enter item code: ");
        int result = binarySearch(0, inventory.size() - 1, scan.nextInt());
        // Checks if found
        if (result == -1) {
            System.out.println("Element not present");
            return false;
        } else
            // Prints item details
            inventory.get(result).printExpiry();
        scan.nextLine();
        return true;
    }

    /**
     * Change the current date
     * 
     * @param scan Scanner for user input
     * @return String, will be null if invalid and will return value if correct
     */
    public String changeTodaysDate(Scanner scan) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Please enter today's date (yyyy-mm-dd):");
        String date = scan.next();
        try {
            LocalDate.parse(date, dateFormat);
        } catch (DateTimeException e) {
            System.out.println("Could not create date from input, please use format yyyy-mm-dd\n" + e.getMessage());
            return null;
        }
        scan.nextLine();
        return date;
    }
}