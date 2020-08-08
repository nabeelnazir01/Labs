import java.util.*;

public class Lab8 {
    public static void main(String[] args) {
        ArrayList<String> dataitems = new ArrayList<String>(100);
        for (int i = 1; i <= 100; ++i)
            dataitems.add("");
        char ch;
        Scanner sr = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Enter String ");
            System.out.println("2. Search a String ");
            System.out.println("3. Exit ");
            System.out.println("Enter your choice :");
            ch = sr.next().charAt(0);
            if (ch == '3')
                break;
            switch (ch) {
                //Add a string
                case '1':
                    System.out.println("Enter your string :");
                    String s = sr.next();
                    int a, b = 0;
                    a = (int) (s.charAt(0));
                    if (s.length() >= 2)
                        b = (int) (s.charAt(1));
                    int index = (a + b) % 100;
                    if (dataitems.get(index) == "")
                        dataitems.add(index, s);
                    else {
                        int f = 1;
                        for (int i = index; i <= 99; ++i) {
                            if (dataitems.get(i) == "") {
                                dataitems.add(i, s);
                                f = 0;
                                break;
                            }
                        }
                        if (f == 1)
                            System.out.println("String cannot be added");
                    }
                    break;
                //Search for string
                case '2':
                    System.out.println("Enter String to be searched");
                    String s1 = sr.next();
                    int a1, b1 = 0;
                    a1 = (int) (s1.charAt(0));
                    if (s1.length() >= 2)
                        b1 = (int) (s1.charAt(1));
                    int index1 = (a1 + b1) % 100;
                    if (s1.equals(dataitems.get(index1)))
                        System.out.println("String found at index " + index1 + ".");
                    else {
                        int f1 = 1;
                        for (int i = index1; i <= 99; ++i) {
                            if (s1.equals(dataitems.get(i))) {
                                System.out.println("String found at index " + index1 + ".");
                                f1 = 0;
                                break;
                            }
                        }
                        if (f1 == 1)
                            System.out.println("String not found.");
                    }
                    break;
                default:
                    System.out.println("Incorrect Choice ");
            }
        }
    }

}