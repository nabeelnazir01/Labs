package ifs;

// Affine parent class with getters for all parameters
public interface AffineTransform{

    public String getName();

    public double[][] getAffine();

    public double getScale();

    public int getHeight();

    public int getWidth();

    public int getXoffset();

    public int getYoffset();
}