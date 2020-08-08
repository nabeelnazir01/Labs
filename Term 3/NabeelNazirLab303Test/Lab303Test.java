import java.util.Scanner;

public class Lab303Test {
    public static void menu() {
        System.out.print("Please select one of the following:" + "\n1: Add Student to College Registrar"
                + "\n2: Display Students in the Registrar" + "\n3: Set College Registrar Name"
                + "\n4: Search for a Student" + "\n5: Exit" + "\nEnter your Selection: ");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String user = "";
        CollegeRegistrar collegeRegistrar = new CollegeRegistrar();
        while (!user.equals("5")) {
            menu();
            user = scan.nextLine();
            switch (user) {
                case "1":
                    collegeRegistrar.addCustomer(scan);
                    break;
                case "2":
                    System.out.println(collegeRegistrar);
                    break;
                case "3":
                    collegeRegistrar.setName(scan);
                    break;
                case "4":
                    collegeRegistrar.searchForStudent(scan);
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Unsupported choice");
                    break;
            }
        }
    }
}