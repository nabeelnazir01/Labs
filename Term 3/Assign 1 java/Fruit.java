import java.util.Scanner;

public class Fruit extends FoodItem {
    String orchardName;

    public Fruit() {
        orchardName = "";
    }

    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + itemPrice + " cost: $"
                + itemCost + " orchard supplier: " + orchardName;
    }

    public boolean addItem(Scanner scanner) {
        super.addItem(scanner);
        System.out.println("Enter the name of the orchard supplier: ");
        scanner.nextLine();
        orchardName = scanner.nextLine();
        return true;
    }
}