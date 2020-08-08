import java.text.NumberFormat;
import java.util.Scanner;
import java.util.regex.*;

public class FoodItem {
    protected int itemCode;
    protected String itemName;
    protected float itemPrice;
    protected float itemCost;
    protected NumberFormat formatter = NumberFormat.getCurrencyInstance();;

    /**
     * Default constructor for FoodItem
     */
    public FoodItem() {
        itemCode = 0;
        itemName = "";
        itemPrice = 0;
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
     * @param scanner  user input
     * @return boolean if successful or not
     */
    public boolean addItem(Scanner scanner) {
        Pattern pattern = Pattern.compile("(\\d+)?(\\.\\d+)?");
        System.out.println("Enter the name for the item: ");
        scanner.nextLine();
        itemName = scanner.nextLine();
        System.out.println("Enter the cost of the item: ");
        String user = scanner.next();
        while (!pattern.matcher(user).matches()) {
            System.out.println("Invalid Cost Try Again!\nEnter the cost of the item: ");
            user = scanner.next();
        }
        itemCost = Float.parseFloat(user);
        System.out.println("Enter the sales price of the item: ");
        user = scanner.next();
        while (!pattern.matcher(user).matches()) {
            System.out.println("Invalid Price Try Again!\nEnter the sales price of the item: ");
            user = scanner.next();
        }
        itemPrice = Float.parseFloat(user);
        return true;
    }

    /**
     * For entering the code for the item being added which will be checked after to
     * see if its already in inventory.
     * 
     * @param scanner  for user input
     * @return boolean if successful or not
     */
    public boolean inputCode(Scanner scanner) {
        Pattern pattern = Pattern.compile("^-?\\d+");
        System.out.println("Enter the code for the item: ");
        String user = scanner.next();
        while (!pattern.matcher(user).matches()) {
            System.out.println("Invalid Code Try Again!\nEnter the code for the item: ");
            user = scanner.next();
        }
        itemCode = Integer.parseInt(user);
        return true;
    }

    public int getItemCode() {
        return itemCode;
    }
}