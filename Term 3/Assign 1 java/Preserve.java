import java.util.Scanner;

public class Preserve extends FoodItem {
    int jarSize;

    public Preserve() {
        jarSize = 0;
    }

    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + itemPrice + " cost: $"
                + itemCost + " size: " + jarSize + "ml";
    }

    public boolean addItem(Scanner scanner) {
        super.addItem(scanner);
        System.out.println("Enter the size of the jar in millilitres: ");
        jarSize = scanner.nextInt();
        scanner.nextLine();
        return true;
    }
}