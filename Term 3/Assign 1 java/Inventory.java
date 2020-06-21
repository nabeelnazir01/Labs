import java.util.Scanner;

public class Inventory {
    private FoodItem[] inventory;
    private int numItems;

    public Inventory() {
        inventory = new FoodItem[20];
        numItems = 0;
    }

    public String toString() {
        String foods = "";
        for (int i = 0; i < numItems; i++) {
            foods += "\n" + inventory[i];
        }
        return "Inventory:"+foods;
    }

    public int alreadyExists(FoodItem item) {
        int position = -1;
        for (int i = 0; i < numItems; i++) {
            if (item.isEqual(inventory[i])) {
                position = i;
            }
        }
        return position;
    }

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

    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
        if (numItems == 0)
            return false;
        System.out.println("Enter a code: ");
        int code = scanner.nextInt();
        String word = buyOrSell ? "Buy" : "Sell";
        for (int i = 0; i < numItems; i++) {
            if (inventory[i].itemCode == code) {
                System.out.println("Enter quantity to " + word + ": ");
                int amount = scanner.nextInt();
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