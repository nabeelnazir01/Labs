package ifs;

// Creates ifs from matrix
public class IfsCreator{

    public static int[][] generateIfs(AffineTransform affineIfs){
        int height = affineIfs.getHeight(), width = affineIfs.getWidth(), xOffset = affineIfs.getXoffset(), yOffset = affineIfs.getYoffset(), row=0, view [][] = new int[width][height];
        double matrix [][] = affineIfs.getAffine(), scale = affineIfs.getScale(), x=0, y=0;
        for(int i=0;i<height*width;i++){
            double randomNum = Math.random(), prob=0;
            for(int n=0;n<matrix.length;n++){
                if(randomNum<matrix[n][6]+prob){
                    row=n;
                    break;
                }
                prob+=matrix[n][6];
            }
            double u = (matrix[row][0]*x)+(matrix[row][1]*y)+matrix[row][4];
            double v = (matrix[row][2]*x)+(matrix[row][3]*y)+matrix[row][5];
            x = u;
            y = v;
            int xDisp = (int) (x*scale+xOffset);
            int yDisp = (int) (y*scale+yOffset);
            view[yDisp][xDisp]++;
        }
        return view;
    }

    // Returns all affines used in program
    public static AffineTransform [] getTransforms(){
        AffineTransform matrix [] = new AffineTransform [4];
        matrix[0] = new SierpinskiIfs();
        matrix[1] = new BarnsleyFernIfs();
        matrix[2] = new MapleIfs();
        matrix[3] = new FileIfs("GoldenDragon.ifs");
        return matrix;
    }
}