import java.util.*;

public class BestF extends SearchAlgo {

    public PriorityQueue<Node> frontier;

    public BestF(Map map, Coord start, Coord goal) {
        this.map1 = map;
        this.map = map.getMap();
        this.start = start;
        this.goal = goal;
        frontier = new PriorityQueue<Node>(1, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                    return o1.costToGoal - o2.costToGoal;
            }
        });
        explored = new LinkedList<Node>();

        bestFSSearch();
    }

    public void bestFSSearch() {

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
                expandBestFS(stateNode, map, frontier, explored);
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
            print += node.getCoord().toString() + ":" + (node.manhattanDistance(goal)) + ',';
        }
        print = print.substring(0, print.length() - 1);
        print += "]";
        System.out.println(print);
    }


    public void expandBestFS(Node stateNode, int[][] map, PriorityQueue<Node> frontier, LinkedList<Node> explored) {

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