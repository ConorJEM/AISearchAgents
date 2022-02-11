import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of breadth first search.
 */
public class BFS extends SearchAlgo {

    public Queue<Node> frontier;

    public BFS(Map map, Coord start, Coord goal){
        this.map1 =map;
        this.map = map.getMap();
        this.start = start;
        this.goal = goal;
        frontier = new LinkedList<Node>();
        explored = new LinkedList<Node>();
        bfsSearch();
    }

    /**
     * Function that contains the main loop of the bfs algorithm.
     */
    public void bfsSearch(){

        Node init = new Node(null, this.start,0,goal);
        Node stateNode;
        frontier.add(init);

        while(!frontier.isEmpty()){

            printFrontier(frontier);
            stateNode =  frontier.poll();
            explored.add(stateNode);

            if(goal.equals(stateNode.getCoord())){


                findRoute(explored, stateNode);

                float dep = stateNode.getDepth();
                System.out.println(dep);
                System.out.println(explored.size());

                frontier.clear();

            } else {
                expandBFS(stateNode, frontier);
            }

        }
        if(!success) {

            System.out.println("fail");
            System.out.println(explored.size());
        }
    }

    /**
     * Function for printing the frontier to the console. All other search algorithms implement have their own version of this function,
     * which are the same but use a different data structure for the frontier.
     * @param frontier
     */
    public void printFrontier(Queue<Node> frontier){
        String print ="";
        print+="[";
        for(Node node:frontier){
            print += node.getCoord().toString()+',';
        }
        print=print.substring(0,print.length()-1);
        print += "]";
        System.out.println(print);
    }

    /**
     * Function to expand the statenote to all possible nodes around it, prioritising in order E,S,W,N. If a node has not been seen yet, add to the frontier.
     * @param stateNode the current position of the agent.
     * @param frontier the current Queue of nodes to explore.
     */
    public void expandBFS(Node stateNode, Queue<Node> frontier){

        LinkedList<Node> tempF = expand(stateNode);

        for(Node node:tempF){
            if(!checkIfSeen(node)){
                frontier.add(node);
            }
        }
    }

    /**
     * Checks if a node is already in the explored list or in the frontier. If not, this function returns False.
     * @param newNode A node that was returns by expanding the stateNode, and needs to be checked to see if we have seen it before
     * @return Boolean, true if the node has been seen before.
     */
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
