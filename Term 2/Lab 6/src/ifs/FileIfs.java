package ifs;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIfs implements AffineTransform {

    private double[][] affine;
    private int height, width, xOffset, yOffset;
    private double scale;
    private String name;

    public FileIfs(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Scanner scanLine = new Scanner(line);
                if (line.contains("name")) {
                    scanLine.next();
                    name = scanLine.nextLine().trim();
                }
                else if (line.contains("height")) {
                    scanLine.next();
                    height = scanLine.nextInt();
                }
                else if (line.contains("width")) {
                    scanLine.next();
                    width = scanLine.nextInt();
                }
                else if (line.contains("xOffset")) {
                    scanLine.next();
                    xOffset = scanLine.nextInt();
                }
                else if (line.contains("yOffset")) {
                    scanLine.next();
                    yOffset = scanLine.nextInt();
                }
                else if (line.contains("scale")) {
                    scanLine.next();
                    scale = scanLine.nextDouble();
                }
                else if (line.contains("affine")) {
                    scanLine.next();
                    int rows = scanLine.nextInt(); //Grabs amount of rows
                    affine = new double[rows][7];
                    for(int i = 0;i < rows;i++){
                        for(int e = 0;e < 7;e++){
                            affine[i][e] = scan.nextDouble();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public double[][] getAffine() {
        return affine;
    }

    public double getScale() {
        return scale;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getXoffset() {
        return xOffset;
    }

    public int getYoffset() {
        return yOffset;
    }
}