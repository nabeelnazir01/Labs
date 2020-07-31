import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;

public class FoodItem {
    protected int itemCode;
    protected String itemName;
    protected float itemPrice;
    protected int itemQuantityInStock;
    protected float itemCost;
    protected NumberFormat formatter = NumberFormat.getCurrencyInstance();;

    /**
     * Default constructor for FoodItem
     */
    public FoodItem() {
        itemCode = 0;
        itemName = "";
        itemPrice = 0;
        itemQuantityInStock = 0;
        itemCost = 0;
    }

    /**
     * @return String value of all instance variables of FoodItem which gets
     *         overridden.
     */
    public String toString() {
        return null;
    }

    /**
     * Updates stock of Item
     * 
     * @param amount how much is being added
     * @return boolean if successful or not
     */
    public boolean updateItem(int amount) {
        if (itemQuantityInStock + amount >= 0) {
            itemQuantityInStock += amount;
            return true;
        }
        System.out.println("Insufficient stock in inventory...");
        return false;
    }

    /**
     * Checks if two FoodItems have the same ItemCode
     * 
     * @param item FoodItem being compared to another
     * @return boolean if successful or not
     */
    public boolean isEqual(FoodItem item) {
        if (item.itemCode == this.itemCode) {
            return true;
        }
        return false;
    }

    /**
     * Asks for all of the values for name, quantity, cost and sales all with error
     * checking.
     * 
     * @param scanner user input
     * @param fromFile if using a file or not
     * @return boolean if successful or not
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        // If using file
        if (fromFile) {
            try {
                // Adds all values to variables
                itemName = scanner.nextLine();
                itemQuantityInStock = Integer.valueOf(scanner.nextLine());
                itemCost = Float.valueOf(scanner.nextLine());
                itemPrice = Float.valueOf(scanner.nextLine());
                return true;
            } catch (InputMismatchException x) {
                System.out.println("ERROR: invalid file");
                return false;
            } catch (NumberFormatException x) {
                System.out.println("ERROR: invalid file data");
                return false;
            }
        } else {
            Pattern pattern2 = Pattern.compile("\\d+");
            Pattern pattern3 = Pattern.compile("(\\d+)?(\\.\\d+)?");
            System.out.println("Enter the name for the item: ");
            scanner.nextLine();
            itemName = scanner.nextLine();
            System.out.println("Enter the quantity for the item: ");
            String user = scanner.next();
            while (!pattern2.matcher(user).matches()) {
                System.out.println("Invalid quantity Try Again!\nEnter the quantity for the item: ");
                user = scanner.next();
            }
            itemQuantityInStock = Integer.parseInt(user);
            System.out.println("Enter the cost of the item: ");
            user = scanner.next();
            while (!pattern3.matcher(user).matches()) {
                System.out.println("Invalid Cost Try Again!\nEnter the cost of the item: ");
                user = scanner.next();
            }
            itemCost = Float.parseFloat(user);
            System.out.println("Enter the sales price of the item: ");
            user = scanner.next();
            while (!pattern3.matcher(user).matches()) {
                System.out.println("Invalid Price Try Again!\nEnter the sales price of the item: ");
                user = scanner.next();
            }
            itemPrice = Float.parseFloat(user);
            return true;
        }
    }

    /**
     * For entering the code for the item being added which will be checked after to
     * see if its already in inventory.
     * 
     * @param scanner for user input
     * @param fromFile if using file or not
     * @return boolean if successful or not
     */
    public boolean inputCode(Scanner scanner, boolean fromFile) {
        if (fromFile)
            itemCode = Integer.valueOf(scanner.nextLine());
        else {
            Pattern pattern = Pattern.compile("^-?\\d+");
            System.out.println("Enter the code for the item: ");
            String user = scanner.next();
            while (!pattern.matcher(user).matches()) {
                System.out.println("Invalid Code Try Again!\nEnter the code for the item: ");
                user = scanner.next();
            }
            itemCode = Integer.parseInt(user);
        }
        return true;
    }

    /**
     * Writes value from FoodItem to file
     * 
     * @param writer Format text onto file
     */
    public void outputItem(java.util.Formatter writer) {
        // Writes every value to file
        writer.format("\n%d", itemCode);
        writer.format("\n%s", itemName);
        writer.format("\n%d", itemQuantityInStock);
        writer.format("\n%.2f", itemCost);
        writer.format("\n%.2f", itemPrice);
    }
}