package ifs;
public class SierpinskiIfs extends AffineTransform{
    private double affine [][] = {{ 0.5, 0, 0, 0.5, 0, 0, 0.33 }, { 0.5, 0, 0, 0.5, 0, 0.5, 0.33 },
    { 0.5, 0, 0, 0.5, 0.43, 0.25, 0.34 }};
    private int height=449,width=519,xOffset=439,yOffset=509;
    private double scale=-500;

    public String getName(){
        return "Sierpinski Gasket";
    }

    public double[][] getAffine(){
        return affine;
    }

    public double getScale(){
        return scale;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getXoffset(){
        return xOffset;
    }

    public int getYoffset(){
        return yOffset;
    }
    }