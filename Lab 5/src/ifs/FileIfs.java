package ifs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIfs extends AffineTransform {

    private double[][] affine;
    private int height, width, xOffset, yOffset;
    private double scale;
    private String name;

    public FileIfs(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.contains("name")) {
                    name = line.substring(5);
                }
                if (line.contains("height")) {
                    height = Integer.parseInt(line.substring(7));
                }
                if (line.contains("width")) {
                    width = Integer.parseInt(line.substring(6));
                }
                if (line.contains("xOffset")) {
                    xOffset = Integer.parseInt(line.substring(8));
                }
                if (line.contains("yOffset")) {
                    yOffset = Integer.parseInt(line.substring(8));
                }
                if (line.contains("scale")) {
                    scale = Double.parseDouble(line.substring(6));
                }
                if (line.contains("affine")) {
                    Pattern r = Pattern.compile("([-+]?[0-9]+\\.+[0-9]+)");
                    int rows = Integer.parseInt(line.substring(7));
                    int column = 0;
                    for (int e = 0; e < rows; e++) {
                        line = scan.nextLine();
                        if (e == 0) {
                            Matcher m = r.matcher(line);
                            while (m.find()) {
                                column++;
                            }
                            affine = new double[rows][column];
                        }
                        Matcher m = r.matcher(line);
                        for (int i = 0; m.find(); i++) {
                            affine[e][i] = Double.parseDouble(m.group(1));
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