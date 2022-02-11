import java.util.LinkedList;
import java.util.Stack;

public class DFS extends SearchAlgo {

    public Stack<Node> frontier;


    public DFS(Map map, Coord start, Coord goal) {
        this.map1 = map;
        this.map = map.getMap();
        this.start = start;
        this.goal = goal;
        frontier = new Stack<Node>();
        explored = new LinkedList<Node>();
        dfsSearch();
    }

    public void dfsSearch() {

        Node init = new Node(null, this.start, 0, goal);
        Node stateNode;
        frontier.add(init);

        while (!frontier.isEmpty()) {

            printFrontier(frontier);
            stateNode = frontier.pop();
            explored.add(stateNode);

            if (goal.equals(stateNode.getCoord())) {

                findRoute(explored, stateNode);
                float dep = stateNode.getDepth();
                System.out.println(dep);
                System.out.println(explored.size());
                frontier.clear();

            } else {

                expandDFS(stateNode, frontier);
            }
        }

        if (!success) {

            System.out.println("fail");
            System.out.println(explored.size());
        }

    }

    public void printFrontier(Stack<Node> frontier) {
        String print = "";
        print += "[";
        for (Node node : frontier) {
            print += node.getCoord().toString() + ',';
        }
        print = print.substring(0, print.length() - 1);
        print += "]";
        System.out.println(print);
    }

    public void expandDFS(Node stateNode, Stack<Node> frontier) {

        LinkedList<Node> tempF = expand(stateNode);

        for (Node node : tempF) {
            if (!checkIfSeen(node)) {
                frontier.add(node);
            }
        }
    }

    public boolean checkIfSeen(Node newnode) {

        for (int i = 0; i < explored.size(); i++) {
            Node tempN = explored.get(i);
            if (tempN.getCoord().equals(newnode.getCoord())) {
                return true;
            }
        }
        for (Node item : frontier) {
            if (newnode.getCoord().equals(item.getCoord())) {
                return true;
            }
        }
        return false;

    }
}