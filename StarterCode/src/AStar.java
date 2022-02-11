import java.util.*;

public class AStar extends SearchAlgo {

    public PriorityQueue<Node> frontier;

    public AStar(Map map, Coord start, Coord goal) {
        this.map1 = map;
        this.map = map.getMap();
        this.start = start;
        this.goal = goal;
        frontier = new PriorityQueue<Node>(1, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                    return (o1.getCostToHere() + o1.getCostToGoal()) - (o2.getCostToHere() + o2.getCostToGoal());
            }
        });
        explored = new LinkedList<Node>();

        aStarSearch();
    }

    public void aStarSearch() {

        Node init = new Node(null, this.start, 0, goal);
        Node stateNode;
        frontier.add(init);

        while (!frontier.isEmpty()) {

            printFrontier(frontier);

            stateNode = frontier.poll();
            explored.add(stateNode);

            if (goal.equals(stateNode.getCoord())) {

                findRoute(explored, stateNode);

                float dep = stateNode.getDepth();
                System.out.println(dep);
                System.out.println(explored.size());

                frontier.clear();

            } else {
                expandAStar(stateNode, frontier);
            }

        }
        if (!success) {


            System.out.println("fail");
            System.out.println(explored.size());
        }
    }

    public void printFrontier(PriorityQueue<Node> frontier) {
        String print = "";
        print += "[";
        for (Node node : frontier) {
            print += node.getCoord().toString() + ":" + (node.getCostToHere() + node.getCostToGoal()) + ',';
        }
        print = print.substring(0, print.length() - 1);
        print += "]";
        System.out.println(print);
    }

    public void expandAStar(Node stateNode, PriorityQueue<Node> frontier) {

        LinkedList<Node> tempF = expand(stateNode);

        for (Node node : tempF) {
            if (!checkIfSeen(node)) {
                frontier.add(node);
            }
        }
    }

    //check if seen or a cheaper route!
    public boolean checkIfSeen(Node newnode) {

        for (int i = 0; i < explored.size(); i++) {
            Node tempN = explored.get(i);
            if (tempN.getCoord().equals(newnode.getCoord())) {
                //if new node with same coords doesnt have a cheaper path, throw out
                return true;
            }
        }
        for (Node item : frontier) {
            if (newnode.getCoord().equals(item.getCoord())) {
                //if new node has the same coords as a node in the frontier, but a cheaper cost, remove other node from frontier
                if (newnode.getCostToHere() + newnode.getCostToGoal() < (item.getCostToHere() + item.getCostToGoal())) {
                    frontier.remove(item); //remove more expensive route to the same node
                    return false; //return false, adding the new node to the frontier
                }
                return true;
            }
        }
        return false;
    }
}