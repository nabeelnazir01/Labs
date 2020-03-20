package ifs;
public class MapleIfs extends AffineTransform{
    private double [][] affine = new double[][] { { 0.51, 0.00, 0.01, 0.14, 1.31, 0.08, 0.10 }, { 0.50, -0.45, 0.52, 0.43, 0.75, -1.49, 0.35 },
    { 0.47, 0.47, -0.49, 0.45, 0.74, 1.62, 0.35}, { 0.51, 0.00, 0.00, 0.49, -1.62, -0.02, 0.20} };
    private int height=702,width=885,xOffset=340,yOffset=445;
    private double scale=100;
    
    /** 
     * @return String
     */
    public String getName(){
        return "Maple Leaf";
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