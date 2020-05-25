import java.util.Scanner;
import ifs.*;
import stl.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Main method of the program
// makes a menu automatically with all ifs
// uses print method to print to file
public class IfsStlFile {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AffineTransform matrix[] = IfsCreator.getTransforms();
        System.out.println("Available fractal images are:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("\t" + (i + 1) + ": " + matrix[i].getName());
        }
        System.out.print("Enter a number between 1 and " + matrix.length + ": ");
        int input = scan.nextInt();
        while (input > matrix.length || input < 1) {
            System.out.print("Not a valid number try again: ");
            input = scan.nextInt();
        }
        scan.close();
        int[][] ifs = IfsCreator.generateIfs(matrix[input - 1]);
        StlImage image = new StlImage(0.8, 4.0);
        Solid solid = image.createSolid(ifs, matrix[input - 1].getName());
        try {
            FileWriter writer = new FileWriter(matrix[input - 1].getName() + ".stl");
            PrintWriter print = new PrintWriter(writer);
            solid.print(print);
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}