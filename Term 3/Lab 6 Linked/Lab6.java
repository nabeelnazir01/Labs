import java.util.LinkedList;
import java.util.Scanner;

public class Lab6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = "";
        do {
            System.out.print("Enter an expression (or exit to terminate): ");
            expression = scan.nextLine().trim();
            if (!expression.equalsIgnoreCase("Exit")) {
                if (checkBalanced(expression))
                    System.out.println("The expression is balanced.\n");
                else
                    System.out.println("The expression is NOT balanced.\n");
            }
        } while (!expression.equalsIgnoreCase("Exit"));
        System.out.println("\nTerminating....");
    }

    /**
     * Checks if char pair are matching braces
     * 
     * @param c1 1st char of pair
     * @param c2 2nd char of pair
     * @return if pair matches
     */
    private static boolean isMatchedPair(char c1, char c2) {
        // Checks if char pair are matching braces
        return (String.valueOf(c1) + c2).equals("()") || (String.valueOf(c1) + c2).equals("{}") ? true : false;
    }

    /**
     * Checks if expression is balanced
     * 
     * @param exp Expression entered
     * @return if balanced
     */
    public static boolean checkBalanced(String exp) {
        LinkedList<String> braces = new LinkedList<>();

        for (int i = 0; i < exp.length(); i++) {
            // Adds starting brace to begining of braces LinkedList
            if (exp.charAt(i) == '(' || exp.charAt(i) == '{') {
                braces.addFirst(String.valueOf(exp.charAt(i)));
            }
            // Checks for ending braces
            else if (exp.charAt(i) == ')' || exp.charAt(i) == '}') {
                // Checks if braces LinkedList is empty and returns false
                if (braces.isEmpty())
                    return false;
                // Checks if the last starting brace is not the right pair for the current brace
                // and returns false
                // Also removes the last starting brace from the braces LinkedList
                else if (!isMatchedPair(braces.removeFirst().charAt(0), exp.charAt(i)))
                    return false;
            }
        }
        // Checks if braces LinkedList are empty and returns true if empty or false if
        // not
        return braces.isEmpty() ? true : false;
    }
}