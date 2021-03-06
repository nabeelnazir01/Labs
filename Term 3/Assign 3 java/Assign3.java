import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * This is a basic inventory system for a produce stand.
 * 
 * @author Nabeel Nazir (040974403) Assignement 2 July 19th 2020
 * @version 1.0
 * @since 1.8
 */
public class Assign3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Inventory inventory = new Inventory();
        LocalDate date = LocalDate.now();
        String user = "";
        while (!user.equals("9")) {
            displayMenu();
            user = scan.nextLine();
            switch (user) {
                case "1":
                    inventory.addItem(scan);
                    break;
                case "2":
                    System.out.println(inventory);
                    break;
                case "3":
                    if (!inventory.updateQuantity(scan, true))
                        System.out.println("Error...could not buy item!");
                    break;
                case "4":
                    if (!inventory.updateQuantity(scan, false))
                        System.out.println("Error...could not sell item!");
                    break;
                case "5":
                    inventory.searchForItem(scan);
                    break;
                case "6":
                    inventory.removeExpired(date);
                    break;
                case "7":
                    if (!inventory.printExpired(scan))
                        System.out.println("Error, could not print expiry for item");
                    break;
                case "8":
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String newDate = inventory.changeTodaysDate(scan);
                    if (newDate != null)
                        date = LocalDate.parse(newDate, dateFormat);
                    break;
                case "9":
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }
        }
    }

    /**
     * Displays the main menu
     */
    public static void displayMenu() {
        System.out.println("Please select one of the following:\n" + "1: Add Item to Inventory\n"
                + "2: Display Current Inventory\n" + "3: Buy Item(s)\n" + "4: Sell Item(s)\n" + "5: Search for Item\n"
                + "6: Remove Expired Items\n" + "7: Print Expiry\n" + "8: Change Today's Date\n" + "9: To Exit");
    }
}