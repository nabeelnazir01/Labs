package ifs;
public class BarnsleyFernIfs extends AffineTransform{

private double affine [][] = {{ 0, 0, 0, 0.16, 0, 0, 0.01 }, { 0.85, 0.04, -0.04, 0.85, 0, 1.6, 0.85 },
        { 0.2, -0.26, 0.23, 0.22, 0, 1.6, 0.07 }, { -0.15, 0.28, 0.26, 0.24, 0, 0.44, 0.07 }};
private int height=503,width=1019,xOffset=228,yOffset=10;
private double scale=100;

public String getName(){
    return "Barnsley Fern";
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