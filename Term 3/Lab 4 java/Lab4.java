import java.util.Scanner;

public class Lab4 {
    static String wordCompare = "";
    static int position = 1;

    /**
     * Checks if a word is a palindrome
     * 
     * @param word being passed through to check if palindrome
     * @return boolean if it is a palindrome or not
     */
    public static boolean isPalindrome(String word) {
        //Checks if whole word has been added
        if ((word.length() - position) >= 0) {
            //Adds letter to string backwards and calls back the method with updated position
            wordCompare += word.charAt(word.length() - position++);
            isPalindrome(word);
        }
        //Returns if the word equals the same backwards
        return word.equalsIgnoreCase(wordCompare);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String user = "";
        while (!user.equals("exit")) {
            System.out.println("Please enter a palindrome or exit to terminate the program: ");
            user = scan.nextLine();
            if (!user.equals("exit")) {
                if (isPalindrome(user))
                    System.out.println("The word "+user+" IS a palindrome");
                else
                    System.out.println("The word "+user+" IS NOT a palindrome");
                wordCompare = "";
                position = 1;
            }
        }
        System.out.println("Bye!");
    }
}