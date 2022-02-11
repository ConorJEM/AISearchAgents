import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectionalSearch extends SearchAlgo {

    public Stack<Node> frontier;


    public DirectionalSearch(Map map, Coord start, Coord goal){
        this.map1 =map;
        this.map = map.getMap();
        this.start = start;
        this.goal = goal;
        frontier = new Stack<Node>();
        explored = new LinkedList<Node>();
        directionalSearch();
    }

    public void directionalSearch(){

        Node init = new Node(null, this.start,0,goal);
        Node stateNode;
        frontier.add(init);

        while(!frontier.isEmpty()){

            printFrontier(frontier);
            stateNode =  frontier.pop();
            explored.add(stateNode);

            if(goal.equals(stateNode.getCoord())){


                findRoute(explored, stateNode);

                float dep = stateNode.getDepth();
                System.out.println(dep);
                System.out.println(explored.size());

                frontier.clear();

            } else {
                expandDirectionalSearch(stateNode, frontier);
            }

        }
        if(!success) {

            System.out.println("fail");
            System.out.println(explored.size());
        }
    }

    public void printFrontier(Stack<Node> frontier){
        String print ="";
        print+="[";
        for(Node node:frontier){
            print += node.getCoord().toString()+',';
        }
        print=print.substring(0,print.length()-1);
        print += "]";
        System.out.println(print);
    }

    public void expandDirectionalSearch(Node stateNode, Stack<Node> frontier){
        LinkedList<Node> tempF = expandDirectional(stateNode);

        for(Node node:tempF){
            if(!checkIfSeen(node)){
                frontier.add(node);
            }
        }
    }


    /**
     * expandDirectional is where the directionalSearch becomes an 'informed' DFS. Calculates in which cardinal direction the goal state is mostly in
     * compared to the statenode, and adds this direction first to the Stack.
     * @param
     * @return
     */

    public LinkedList<Node> expandDirectional(Node stateNode){

        LinkedList<Node> tempF = new LinkedList<Node>();

        int c1 = stateNode.getCoord().getC();
        int r1 = stateNode.getCoord().getR();

        int r2 = goal.getR();
        int c2 = goal.getC();


        int verticalDif = r1-r2;
        int horizontalDif = c1-c2;

        if(Math.abs(verticalDif)>Math.abs(horizontalDif)){ //MORE VERTICAL
            if(verticalDif<=0){ //MOST SOUTH

                if(stateNode.getDir()==1 && map1.checkValid(new Coord(r1 - 1, c1))) { //Triangle facing down, //CHECK NORTH
                    tempF.add(new Node(stateNode, new Coord(r1 - 1, c1), goal));
                }

                if(map1.checkValid(new Coord(r1,c1+1))){  // CHECK EAST
                    tempF.add(new Node(stateNode, new Coord(r1,c1+1),goal));
                }
                if(stateNode.getDir()==0 && map1.checkValid(new Coord(r1+1,c1))) {  //Triangle facing up, //SOUTH
                    tempF.add(new Node(stateNode, new Coord(r1+1,c1),goal));
                }
                if(map1.checkValid(new Coord(r1,c1-1))){ //CHECK WEST
                    tempF.add(new Node(stateNode, new Coord(r1,c1-1),goal));
                }
            }else{ //MOSTLY NORTH
                if(stateNode.getDir()==0 && map1.checkValid(new Coord(r1+1,c1))) {  //Triangle facing up, //SOUTH
                    tempF.add(new Node(stateNode, new Coord(r1+1,c1),goal));
                }
                if(map1.checkValid(new Coord(r1,c1-1))){ //CHECK WEST
                    tempF.add(new Node(stateNode, new Coord(r1,c1-1),goal));
                }
                if(map1.checkValid(new Coord(r1,c1+1))){  // CHECK EAST
                    tempF.add(new Node(stateNode, new Coord(r1,c1+1),goal));
                }
                if(stateNode.getDir()==1 && map1.checkValid(new Coord(r1 - 1, c1))) { //Triangle facing down, //CHECK NORTH
                    tempF.add(new Node(stateNode, new Coord(r1 - 1, c1), goal));
                }
            }
        }else{
            if(horizontalDif<=0){ //MOSTLY EAST
                if(map1.checkValid(new Coord(r1,c1-1))){ //CHECK WEST
                    tempF.add(new Node(stateNode, new Coord(r1,c1-1),goal));
                }
                if(stateNode.getDir()==1 && map1.checkValid(new Coord(r1 - 1, c1))) { //Triangle facing down, //CHECK NORTH
                    tempF.add(new Node(stateNode, new Coord(r1 - 1, c1), goal));
                }
                if(stateNode.getDir()==0 && map1.checkValid(new Coord(r1+1,c1))) {  //Triangle facing up, //SOUTH
                    tempF.add(new Node(stateNode, new Coord(r1+1,c1),goal));
                }
                if(map1.checkValid(new Coord(r1,c1+1))){  // CHECK EAST
                    tempF.add(new Node(stateNode, new Coord(r1,c1+1),goal));
                }
            }else{ //MOSTLY WEST
                if(map1.checkValid(new Coord(r1,c1+1))){  // CHECK EAST
                    tempF.add(new Node(stateNode, new Coord(r1,c1+1),goal));
                }
                if(stateNode.getDir()==0 && map1.checkValid(new Coord(r1+1,c1))) {  //Triangle facing up, //SOUTH
                    tempF.add(new Node(stateNode, new Coord(r1+1,c1),goal));
                }
                if(stateNode.getDir()==1 && map1.checkValid(new Coord(r1 - 1, c1))) { //Triangle facing down, //CHECK NORTH
                    tempF.add(new Node(stateNode, new Coord(r1 - 1, c1), goal));
                }
                if(map1.checkValid(new Coord(r1,c1-1))){ //CHECK WEST
                    tempF.add(new Node(stateNode, new Coord(r1,c1-1),goal));
                }
            }

        }

        return tempF;
    }


//
//    public LinkedList<Node> expandDirectional(Node stateNode){
//
//        LinkedList<Node> tempF = new LinkedList<Node>();
//
//        int c1 = stateNode.getCoord().getC();
//        int r1 = stateNode.getCoord().getR();
//
//
//        int r2 = goal.getR();
//        int c2 = goal.getC();
//
//
//        int verticalDif = r1-r2;
//        int horizontalDif = c1-c2;
//
//
//        if(Math.abs(verticalDif)>Math.abs(horizontalDif)){ //MORE VERTICAL
//            if(verticalDif<=0){ //MOST SOUTH
//                checkNorth(stateNode,r1,c1,tempF);
//                checkEast(stateNode,r1,c1,tempF);
//                checkSouth(stateNode,r1,c1,tempF);
//                checkWest(stateNode,r1,c1,tempF);
//            }else{ //MOSTLY NORTH
//                checkSouth(stateNode,r1,c1,tempF);
//                checkWest(stateNode,r1,c1,tempF);
//                checkEast(stateNode,r1,c1,tempF);
//                checkNorth(stateNode,r1,c1,tempF);
//            }
//        }else{
//            if(horizontalDif<=0){ //MOSTLY EAST
//                checkWest(stateNode,r1,c1,tempF);
//                checkNorth(stateNode,r1,c1,tempF);
//                checkSouth(stateNode,r1,c1,tempF);
//                checkEast(stateNode,r1,c1,tempF);
//            }else{ //MOSTLY WEST
//                checkEast(stateNode,r1,c1,tempF);
//                checkSouth(stateNode,r1,c1,tempF);
//                checkNorth(stateNode,r1,c1,tempF);
//                checkWest(stateNode,r1,c1,tempF);
//            }
//
//        }
//
//        return tempF;
//
//    }



    public boolean checkIfSeen(Node newNode){

        for (Node tempN : explored) {
            if (tempN.getCoord().equals(newNode.getCoord())) {
                return true;
            }
        }
        for(Node item:frontier){
            if(newNode.getCoord().equals(item.getCoord())){
                return true;
            }
        }
        return false;
    }

}