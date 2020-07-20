import java.util.Scanner;

public class Fruit extends FoodItem {
    private String orchardName;

    /**
     * Default constructor for Fruit
     */
    public Fruit() {
        orchardName = "";
    }

    /**
     * @return String value of all instance variables of FoodItem.
     */
    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: " + formatter.format(itemPrice) + " cost: "
                + formatter.format(itemCost) + " orchard supplier: " + orchardName;
    }

    /**
     * Adds item to inventory and calls super class plus the orchard supplier
     * specially for this class.
     * 
     * @return boolean to see if successful
     */
    public boolean addItem(Scanner scanner) {
        super.addItem(scanner);
        System.out.println("Enter the name of the orchard supplier: ");
        scanner.nextLine();
        orchardName = scanner.nextLine();
        return true;
    }
}