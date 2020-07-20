import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class lab5 {
    /**
     * Finds position of integer in array using binary search
     * 
     * @param array Array where the integer needs to be found.
     * @param l     1 of 2 integers to find middle of array.
     * @param r     1 of 2 integers to find middle of array.
     * @param x     Number needed to be found.
     * @return      Integer of position of value in array. Will return -1 if not found.
     */
    public static int binarySearch(ArrayList<Integer> array, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (array.get(mid) == x)
                return mid;
            if (array.get(mid) > x)
                return binarySearch(array, l, mid - 1, x);
            return binarySearch(array, mid + 1, r, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String user = "";
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (!user.equals("4")) {
            System.out.println("Please Enter:\n1. Add Item\n2. Search for Item\n3. Display List\n4. Exit");
            user = scan.nextLine();
            switch (user) {
                case "1":
                    System.out.println("Please specify an Integer:");
                    try {
                        array.add(scan.nextInt());
                        Collections.sort(array);
                    } catch (InputMismatchException e) {
                        System.out.println("Input needs to be a integer!");
                    }
                    scan.nextLine();
                    break;
                case "2":
                    System.out.println("Please specify an Integer:");
                    try {
                        int result = binarySearch(array, 0, array.size() - 1, scan.nextInt());
                        if (result == -1)
                            System.out.println("Element not present");
                        else
                            System.out.println("Index of Integer is: " + result);
                    } catch (InputMismatchException e) {
                        System.out.println("Input needs to be a integer!");
                    }
                    scan.nextLine();
                    break;
                case "3":
                    System.out.println(array);
                    break;
                case "4":
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }
}