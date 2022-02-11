import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;
public class NodeTest {

    /**
     *Check that the manhattanDistance function is correctly calculating the correct cost.
     */
    @Test
    public void nodeTest1() {
        Coord goal = new Coord(5,5);
        Node root = new Node(null,new Coord(0,0),0,goal);

        assertTrue(root.manhattanDistance(goal)==10.0);

    }

    @Test
    public void nodeTest2() {
        Coord goal = new Coord(2,3);
        Node root = new Node(null,new Coord(4,3),0,goal);

        assertTrue(root.manhattanDistance(goal)==4);

    }

    @Test
    public void nodeTest3() {
        Coord goal = new Coord(2,0);
        Node root = new Node(null,new Coord(0,0),0,goal);

        assertTrue(root.manhattanDistance(goal)==4);

    }
    @Test
    public void nodeTest4() {
        Coord goal = new Coord(2,0);
        Node root = new Node(null,new Coord(2,0),0,goal);

        assertTrue(root.getDir()==0);

    }
    @Test
    public void nodeTest5() {
        Coord goal = new Coord(2,1);
        Node root = new Node(null,new Coord(2,1),0,goal);
        System.out.println(root.getCoord().getC()%2);
        System.out.println(root.getCoord().getR()%2);
        assertTrue(root.getDir()==1);

    }
    @Test
    public void nodeTest6() {
        Coord goal = new Coord(2,1);
        Node root = new Node(null,new Coord(2,3),0,goal);

        assertTrue(root.getDir()==1);

    }

}