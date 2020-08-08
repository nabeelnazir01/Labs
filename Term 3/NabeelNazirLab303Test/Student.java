import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    String studentName;
    int studentNumber;
    float Balance;

    public Student() {
        studentName = "";
        studentNumber = 0;
        Balance = 0;
    }

    public boolean newCustomer(Scanner scan) {
        String user;
        Pattern pattern = Pattern.compile("\\d+");
        Pattern pattern2 = Pattern.compile("(\\d+)?(\\.\\d+)?");
        System.out.println("Please Enter the Student's Name: ");
        studentName = scan.nextLine();
        System.out.println("Please Enter the Student Number: ");
        user = scan.nextLine();
        if (!pattern.matcher(user).matches()) {
            System.out.println("Incorrect format");
            return false;
        }
        studentNumber = Integer.valueOf(user);
        System.out.println("Please Enter the Student's Balance: ");
        user = scan.nextLine();
        if (!pattern2.matcher(user).matches()) {
            System.out.println("Incorrect format");
            return false;
        }
        Balance = Float.valueOf(user);
        return true;
    }

    @Override
    public String toString() {
        return "Student #: " + studentNumber + ", Name: " + studentName + ", Balance: $" + Balance;
    }
}