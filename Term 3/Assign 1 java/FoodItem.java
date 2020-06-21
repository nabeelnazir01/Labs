import java.util.Scanner;
import java.util.regex.*;

public class FoodItem {
    int itemCode;
    String itemName;
    float itemPrice;
    int itemQuantityInStock;
    float itemCost;

    public FoodItem() {
        itemCode = 0;
        itemName = "";
        itemPrice = 0;
        itemQuantityInStock = 0;
        itemCost = 0;
    }

    public String toString() {
        return null;
    }

    public boolean updateItem(int amount) {
        if (itemQuantityInStock + amount >= 0) {
            itemQuantityInStock += amount;
            return true;
        }
        System.out.println("Insufficient stock in inventory...");
        return false;
    }

    public boolean isEqual(FoodItem item) {
        if (item.itemCode == this.itemCode) {
            return true;
        }
        return false;
    }

    public boolean addItem(Scanner scanner) {
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
}