import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory {
    private FoodItem[] inventory;
    private int numItems;

    /**
     * Default constructor for Inventory
     */
    public Inventory() {
        inventory = new FoodItem[20];
        numItems = 0;
    }

    /**
     * @return String value of all foods in inventory
     */
    public String toString() {
        String foods = "";
        for (int i = 0; i < numItems; i++) {
            foods += "\n" + inventory[i];
        }
        return "Inventory:" + foods;
    }

    /**
     * Finds FoodItem that has same item code as the one passed through. If not
     * found it will return -1.
     * 
     * @param item FoodItem being located
     * @return int which is position of food item that has same item code
     */
    public int alreadyExists(FoodItem item) {
        int position = -1;
        for (int i = 0; i < numItems; i++) {
            if (item.isEqual(inventory[i])) {
                position = i;
            }
        }
        return position;
    }

    /**
     * Makes a new object for food item type and checks if already exists and then
     * uses addItem food method to add new item.
     * 
     * @param scanner user input
     * @return boolean if it was successful
     */
    public boolean addItem(Scanner scanner) {
        System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
        String user = scanner.next();
        switch (user.toUpperCase()) {
            case "F":
                inventory[numItems] = new Fruit();
                inventory[numItems].inputCode(scanner);
                if (alreadyExists(inventory[numItems]) != -1) {
                    System.out.println("Item code already exists");
                    return false;
                }
                inventory[numItems++].addItem(scanner);
                return true;
            case "V":
                inventory[numItems] = new Vegetable();
                inventory[numItems].inputCode(scanner);
                if (alreadyExists(inventory[numItems]) != -1) {
                    System.out.println("Item code already exists");
                    return false;
                }
                inventory[numItems++].addItem(scanner);
                return true;
            case "P":
                inventory[numItems] = new Preserve();
                inventory[numItems].inputCode(scanner);
                if (alreadyExists(inventory[numItems]) != -1) {
                    System.out.println("Item code already exists");
                    return false;
                }
                inventory[numItems++].addItem(scanner);
                return true;
            default:
                System.out.println("Invalid option!");
                this.addItem(scanner);
        }
        return false;
    }

    /**
     * Adds or subtracts from item quantity depending on buy and sell
     * 
     * @param scanner   reads user input
     * @param buyOrSell Will be true if buy, false if sell
     * @return boolean that says if it was successful or not
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
        int amount;
        if (numItems == 0)
            return false;
        int code;
        System.out.println("Enter a code: ");
        try {
            code = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return false;
        }
        String word = buyOrSell ? "Buy" : "Sell";
        for (int i = 0; i < numItems; i++) {
            if (inventory[i].itemCode == code) {
                System.out.println("Enter quantity to " + word + ": ");
                try {
                    amount = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    scanner.nextLine();
                    return false;
                }
                if (amount < 0) {
                    System.out.println("Invalid quantity...");
                    return false;
                } else if (buyOrSell)
                    return inventory[i].updateItem(amount);
                else
                    return inventory[i].updateItem(-amount);
            }
        }
        System.out.println("Code can not be found in inventory...");
        return false;
    }
}