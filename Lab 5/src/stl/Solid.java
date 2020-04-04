package stl;
import java.util.ArrayList;
import java.io.PrintWriter; 

// Solid class which contains list of facets
public class Solid{
    private String name;
    private ArrayList<Facet> facets = new ArrayList<Facet>();

    public Solid(){
        name=null;
    }
    public Solid(String name){
        this.name=name;
    }

    // Adds facets to list
    public boolean addFacet(Facet facet){
        try {
            facets.add(facet);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Makes vertices into facets then adds to list
    public boolean addFacet(Vertex... vertices) {
		if(vertices.length<3){
			return false;
		}
        for(int i = 0; i < vertices.length-2; i++) {
            addFacet(new Facet(vertices[0], vertices[i+1], vertices[i+2]));
        }
        return true;
    }

    // Prints to file
    public void print(PrintWriter printWriter){
        printWriter.println(this);
    }

    // What the solid object will print when called
    public String toString(){
        StringBuilder facetString = new StringBuilder();
        for(int i = 0; i < facets.size(); i++) {
            facetString.append(facets.get(i));
        }
        return "solid " + name +"\n" + facetString.toString() + "endsolid " + name;
    }   
}