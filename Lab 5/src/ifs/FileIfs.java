package ifs;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

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
                    // String [] find = line.split("name\\s+");
                    // name = find[1];
                    Scanner scanner = new Scanner(line);
                    scanner.next();
                    name = scanner.nextLine().trim();
                }
                else if (line.contains("height")) {
                    // String [] find = line.split("\\s+");
                    // height = Integer.valueOf(find[1]);
                    Scanner scanner = new Scanner(line);
                    scanner.next();
                    height = scanner.nextInt();
                }
                else if (line.contains("width")) {
                    // String [] find = line.split("\\s+");
                    // width = Integer.valueOf(find[1]);
                    Scanner scanner = new Scanner(line);
                    scanner.next();
                    width = scanner.nextInt();
                }
                else if (line.contains("xOffset")) {
                    // String [] find = line.split("\\s+");
                    // xOffset = Integer.valueOf(find[1]);
                    Scanner scanner = new Scanner(line);
                    scanner.next();
                    xOffset = scanner.nextInt();
                }
                else if (line.contains("yOffset")) {
                    // String [] find = line.split("\\s+");
                    // yOffset = Integer.valueOf(find[1]);
                    Scanner scanner = new Scanner(line);
                    scanner.next();
                    yOffset = scanner.nextInt();
                }
                else if (line.contains("scale")) {
                    // String [] find = line.split("\\s+");
                    // scale = Double.valueOf(find[1]);
                    Scanner scanner = new Scanner(line);
                    scanner.next();
                    scale = scanner.nextDouble();
                }
                else if (line.contains("affine")) {
                    // int rows = Integer.parseInt(line.substring(7));
                    Scanner scanner = new Scanner(line);
                    scanner.next();
                    int rows = scanner.nextInt();
                    ArrayList <Double> affineNum = new ArrayList<Double>();
                    int count = 0;
                    while (scan.hasNextDouble()) {
                        affineNum.add(scan.nextDouble());
                    }
                    int column = affineNum.size() / rows;
                    affine = new double[rows][column];
                    for (int i = 0; i < rows; i++) {
                        for (int e = 0; e < column; e++) {
                            affine[i][e] = affineNum.get(count);
                            count++;
                        }
                    }
                    // Regex method
                    // Pattern r = Pattern.compile("([-+]?[0-9]+\\.+[0-9]+)");
                    // int rows = Integer.parseInt(line.substring(7));
                    // int column = 0;
                    // for (int e = 0; e < rows; e++) {
                    // line = scan.nextLine();
                    // if (e == 0) {
                    // Matcher m = r.matcher(line);
                    // while (m.find()) {
                    // column++;
                    // }
                    // affine = new double[rows][column];
                    // }
                    // Matcher m = r.matcher(line);
                    // for (int i = 0; m.find(); i++) {
                    // affine[e][i] = Double.parseDouble(m.group(1));
                    // }
                    // }
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