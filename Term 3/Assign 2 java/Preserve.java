import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.*;

public class Preserve extends FoodItem {
    private int jarSize;

    /**
     * Default constructor for Preserve
     */
    public Preserve() {
        jarSize = 0;
    }

    /**
     * @return String value of all instance variables of FoodItem.
     */
    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: "
                + formatter.format(itemPrice) + " cost: " + formatter.format(itemCost) + " size: " + jarSize + "ml";
    }

    /**
     * Adds item to inventory and calls super class plus the jar specially for this
     * class.
     * 
     * @param fromFile if using a file or not
     * @return boolean to see if successful
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (fromFile) {
            if (!scanner.hasNextLine()) {
                return false;
            }
            super.addItem(scanner, true);
            jarSize = Integer.valueOf(scanner.nextLine());
            return true;
        } else {
            Pattern pattern = Pattern.compile("\\d+");
            super.addItem(scanner, false);
            scanner.nextLine();
            System.out.println("Enter the size of the jar in millilitres: ");
            String size = scanner.nextLine();
            while (!pattern.matcher(size).matches()) {
                System.out.println("Invalid Amount Try Again!\nEnter the size of the jar in millilitres: ");
                size = scanner.nextLine();
            }
            jarSize = Integer.parseInt(size);
            return true;
        }
    }

    /**
     * Outputs jarSize to file
     */
    public void outputItem(Formatter writer) {
        super.outputItem(writer);
        writer.format("\n%s", jarSize);
    }
}