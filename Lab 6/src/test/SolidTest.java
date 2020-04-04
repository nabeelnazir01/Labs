package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import stl.*;

public class SolidTest {
    @Test
    public void testInvalid() {
        Solid s1 = new Solid();
        Solid s2 = new Solid();
        Vertex v1 = new Vertex(0,1,2);
        assertEquals(s1.addFacet(v1), false);
        assertEquals(s1.toString(), s2.toString());
    }

    @Test
    public void test3() {
        Solid s1 = new Solid();
        Solid s2 = new Solid();
        Vertex v1 = new Vertex(0,1,2);
        Vertex v2 = new Vertex(0,1,3);
        Vertex v3 = new Vertex(0,1,4);
        Facet f1 = new Facet(v1,v2,v3);
        s2.addFacet(f1);
        assertEquals(s1.addFacet(v1,v2,v3),true);
        assertEquals(s1.toString(),s2.toString());
    }

    @Test
    public void test4() {
        Solid s1 = new Solid();
        Solid s2 = new Solid();
        Vertex v1 = new Vertex(0,1,2);
        Vertex v2 = new Vertex(0,1,3);
        Vertex v3 = new Vertex(0,1,4);
        Vertex v4 = new Vertex(0,1,5);
        Facet f1 = new Facet(v1,v2,v3);
        Facet f2 = new Facet(v1,v3,v4);
        assertEquals(s1.addFacet(v1,v2,v3,v4),true);
        s2.addFacet(f1);
        s2.addFacet(f2);
        assertEquals(s1.toString(),s2.toString());
    }    

    @Test
    public void test9() {
        Solid s1 = new Solid();
        Solid s2 = new Solid();
        Vertex v1 = new Vertex(0,1,2);
        Vertex v2 = new Vertex(0,1,3);
        Vertex v3 = new Vertex(0,1,4);
        Vertex v4 = new Vertex(0,1,5);
        Vertex v5 = new Vertex(0,1,6);
        Vertex v6 = new Vertex(0,1,7);
        Vertex v7 = new Vertex(0,1,8);
        Vertex v8 = new Vertex(0,1,9);
        Vertex v9 = new Vertex(0,1,10);
        Facet f1 = new Facet(v1,v2,v3);
        Facet f2 = new Facet(v1,v3,v4);
        Facet f3 = new Facet(v1,v4,v5);
        Facet f4 = new Facet(v1,v5,v6);
        Facet f5 = new Facet(v1,v6,v7);
        Facet f6 = new Facet(v1,v7,v8);
        Facet f7 = new Facet(v1,v8,v9);
        assertEquals(s1.addFacet(v1,v2,v3,v4,v5,v6,v7,v8,v9),true);
        s2.addFacet(f1);
        s2.addFacet(f2);
        s2.addFacet(f3);
        s2.addFacet(f4);
        s2.addFacet(f5);
        s2.addFacet(f6);
        s2.addFacet(f7);
        assertEquals(s1.toString(),s2.toString());
    } 
}