import java.util.Scanner;

public class Vegetable extends FoodItem {
    String farmName;

    public Vegetable() {
        farmName = "";
    }

    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + itemPrice + " cost: $"
                + itemCost + " farm supplier: " + farmName;
    }

    public boolean addItem(Scanner scanner) {
        super.addItem(scanner);
        System.out.println("Enter the name of the farm supplier: ");
        scanner.nextLine();
        farmName = scanner.nextLine();
        return true;
    }
}