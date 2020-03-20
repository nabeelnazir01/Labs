package ifs;
public class SierpinskiIfs extends AffineTransform{
    private double affine [][] = {{ 0.5, 0, 0, 0.5, 0, 0, 0.33 }, { 0.5, 0, 0, 0.5, 0, 0.5, 0.33 },
    { 0.5, 0, 0, 0.5, 0.43, 0.25, 0.34 }};
    private int height=449,width=519,xOffset=439,yOffset=509;
    private double scale=-500;
    
    /** 
     * @return String
     */
    public String getName(){
        return "Sierpinski Gasket";
    }
    
    /** 
     * @return double[][]
     */
    public double[][] getAffine(){
        return affine;
    }
    
    /** 
     * @return double
     */
    public double getScale(){
        return scale;
    }
    
    /** 
     * @return int
     */
    public int getHeight(){
        return height;
    }
    
    /** 
     * @return int
     */
    public int getWidth(){
        return width;
    }
    
    /** 
     * @return int
     */
    public int getXoffset(){
        return xOffset;
    }
    
    /** 
     * @return int
     */
    public int getYoffset(){
        return yOffset;
    }
    }