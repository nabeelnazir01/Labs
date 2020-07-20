import java.util.Formatter;
import java.util.Scanner;

public class Vegetable extends FoodItem {
    private String farmName;

    /**
     * Default constructor for Vegetable
     */
    public Vegetable() {
        farmName = "";
    }

    /**
     * @return String value of all instance variables of FoodItem.
     */
    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: "
                + formatter.format(itemPrice) + " cost: " + formatter.format(itemCost) + " farm supplier: " + farmName;
    }

    /**
     * Adds item to inventory and calls super class plus the farm supplier specially
     * for this class.
     * 
     * @return boolean to see if successful
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (fromFile) {

            if (!scanner.hasNextLine()) {
                return false;
            }
            farmName = scanner.nextLine();
            return true;
        } else {
            super.addItem(scanner, false);
            System.out.println("Enter the name of the farm supplier: ");
            scanner.nextLine();
            farmName = scanner.nextLine();
            return true;
        }
    }

    public void outputItem(Formatter writer) {
        super.outputItem(writer);
        writer.format("\n%s", farmName);
    }
}