package stl;

//Represents StlImage
public class StlImage{
    private double minThick, thickScale, scale=0.1, maxValue;

    public StlImage(double min, double max){
        this.minThick = min;
        this.thickScale = max-min;
    }

    //Creates vertex then returns the solid
    public Solid createSolid(int[][] matrix, String name){
        maxValue = matrix[0][0];
        int width = matrix[0].length;
        int length = matrix.length;
       Solid solid = new Solid(name);
       for (int[] i: matrix){
        for (int e: i)
            maxValue = (e>maxValue) ? e:maxValue;
       }
       for(int x=0;x<matrix.length-1;x++){
           for(int y=0;y<matrix[x].length-1;y++){
            solid.addFacet(createIfsVertex(x, y, matrix[x][y]),createIfsVertex(x+1, y, matrix[x+1][y]),createIfsVertex(x+1, y+1, matrix[x+1][y+1]),createIfsVertex(x, y+1, matrix[x][y+1]));
           }
       }
            solid.addFacet(createIfsVertex(0, 0, 0),createIfsVertex(width*scale, 0, 0),createIfsVertex(width*scale, 0, minThick),createIfsVertex(0, 0, minThick));
            solid.addFacet(createIfsVertex(0, length*scale, 0),createIfsVertex(0, 0, 0),createIfsVertex(0,0,minThick),createIfsVertex(0, length*scale,minThick));
            solid.addFacet(createIfsVertex(width*scale, 0, 0),createIfsVertex(width*scale, length*scale, 0),createIfsVertex(width*scale, length*scale,minThick),createIfsVertex(width*scale, 0, minThick));
            solid.addFacet(createIfsVertex(width*scale, length*scale, 0),createIfsVertex(0, length*scale, 0),createIfsVertex(0, length*scale, minThick),createIfsVertex(width*scale, length*scale, minThick));
            solid.addFacet(createIfsVertex(0, 0, 0),createIfsVertex(0, length*scale, 0),createIfsVertex(width*scale, length*scale, 0),createIfsVertex(width*scale, 0, 0));
            return solid;
    }

    //Creates vertex
    private Vertex createIfsVertex(double x, double y, double z){
        return new Vertex(x*this.scale, y*this.scale, minThick+thickScale*Math.sqrt(z/maxValue));
    }
}