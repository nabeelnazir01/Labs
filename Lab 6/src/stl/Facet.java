package stl;

// Represents facets which are made up of 3 vertices
public class Facet{
    private Vertex normal;
    private Vertex v1,v2,v3;

    //Initial constructor
    public Facet(Vertex v1,Vertex v2,Vertex v3){
        this.v1=v1;
        this.v2=v2;
        this.v3=v3;
        normal=Vertex.calcNormal(v1,v2,v3);
    }

    // What the facet object will print when called
    public String toString(){
		return "facet normal "+normal+"\n outer loop"+"\n  vertex "+v1+"\n  vertex "+v2+"\n  vertex "+v3+"\n endloop"+"\nendfacet\n";
    }
}