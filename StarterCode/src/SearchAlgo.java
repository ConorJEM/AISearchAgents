import java.util.LinkedList;

import java.util.Stack;

/**
 * Abstract class that all the search algorithms extend. Contains the fields and methods that are shared between the search algorithms.
 */
public abstract class SearchAlgo {

    public int[][] map;
    public Map map1;
    public Coord start;
    public Coord goal;
    public LinkedList<Node> explored;
    public boolean success;

    public void findRoute(LinkedList<Node> explored, Node stateNode){
        Stack<Node> route = new Stack<Node>();
        while (stateNode.getParent() != null){
            route.push(stateNode);
            stateNode = stateNode.getParent();
        }
        route.push(stateNode);
        while(!route.isEmpty()){
            System.out.print(route.pop().getCoord().toString());
        }
        System.out.println(" ");

        success=true;
    }

    /**
     * This function checks each direction , E, S , W , N of the the current stateNode and checks if that coordinate is a valid move.
     * @param stateNode the current agent location
     * @return tempF, a linkedlist of all the valid move location nodes.
     */
    public LinkedList<Node> expand(Node stateNode){

        LinkedList<Node> tempF = new LinkedList<Node>();

        int c = stateNode.getCoord().getC();
        int r = stateNode.getCoord().getR();

        if(map1.checkValid(new Coord(r,c+1))){  //EAST
            tempF.add(new Node(stateNode, new Coord(r,c+1),goal));
        }

        if(stateNode.getDir()==0 && map1.checkValid(new Coord(r+1,c))) {  //Triangle pointing up, //SOUTH
                tempF.add(new Node(stateNode, new Coord(r+1,c),goal));
        }

        if(map1.checkValid(new Coord(r,c-1))){ //WEST
            tempF.add(new Node(stateNode, new Coord(r,c-1),goal));
        }

        if(stateNode.getDir()==1 && map1.checkValid(new Coord(r - 1, c))) { //Triangle pointing down, //NORTH
                tempF.add(new Node(stateNode, new Coord(r - 1, c), goal));
        }

        return tempF;

    }

}
