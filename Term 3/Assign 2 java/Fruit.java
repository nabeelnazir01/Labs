import java.util.Formatter;
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
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: "
                + formatter.format(itemPrice) + " cost: " + formatter.format(itemCost) + " orchard supplier: "
                + orchardName;
    }

    /**
     * Adds item to inventory and calls super class plus the orchard supplier
     * specially for this class.
     * 
     * @return boolean to see if successful
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (fromFile) {

            if (!scanner.hasNextLine()) {
                return false;
            }
            orchardName = scanner.nextLine();
            return true;
        } else {
            super.addItem(scanner, false);
            System.out.println("Enter the name of the orchard supplier: ");
            scanner.nextLine();
            orchardName = scanner.nextLine();
            return true;
        }
    }

    public void outputItem(Formatter writer) {
        super.outputItem(writer);
        writer.format("\n%s", orchardName);
    }
}