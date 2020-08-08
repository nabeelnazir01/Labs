import java.util.Scanner;
import java.util.regex.Pattern;

public class CollegeRegistrar {
    Student students[];
    String name;
    int amount;

    public CollegeRegistrar() {
        students = new Student[20];
        name = "Unknown";
        amount = 0;
    }

    public Student[] bubbleSort() {
        Student[] array = students.clone();
        for (int i = (amount - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (array[j - 1].studentNumber > array[j].studentNumber) {
                    Student temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public void setName(Scanner scan) {
        System.out.println("Please Enter the College Registrar's Name: ");
        name = scan.nextLine();
    }

    public void addCustomer(Scanner scan) {
        students[amount] = new Student();
        if (students[amount].newCustomer(scan)) {
            amount++;
            students = bubbleSort();
        }
    }

    public int binarySearch(int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (students[mid].studentNumber == x)
                return mid;
            if (students[mid].studentNumber > x)
                return binarySearch(l, mid - 1, x);
            return binarySearch(mid + 1, r, x);
        }
        return -1;
    }

    public void displayAll() {
        System.out.println("College Registrar Information:\nName: " + name + "\nStudent List:");
        for (Student i : students) {
            System.out.println(i);
        }
    }

    public void searchForStudent(Scanner scanner) {
        System.out.println("Please Enter the Student Number to Search for: ");
        String user;
        Pattern pattern = Pattern.compile("\\d+");
        user = scanner.nextLine();
        if (!pattern.matcher(user).matches()) {
            System.out.println("Incorrect format");
            return;
        }
        int result = binarySearch(0, amount - 1, Integer.valueOf(user));
        if (result == -1)
            System.out.println("Student not found in College Registrar");
        else
            System.out.println("Student found at index " + (result-1) + "\n" + students[result]);
    }

    @Override
    public String toString() {
        String words = "";
        words += "College Registrar Information:\nName: " + name + "\nStudent List:\n";
        if (amount == 0)
            words += "No Students in College Registrar";
        for (int i = 0; i < amount; i++) {
            words += students[i] + "\n";
        }
        return words;
    }
}