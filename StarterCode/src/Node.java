public class Node {

    public Node parent;
    public Node(){};
    public Coord coord;
    public int depth;
    public int dir;
    public int costToHere;
    public int costToGoal;
    public Coord goal;

    public Node(Node parent,Coord coord,Coord goal){
        this.parent = parent;
        this.coord = coord;
        this.depth = parent.depth + 1;
        this.dir = findDir();
        this.goal = goal;
        this.costToGoal = manhattanDistance(goal);
        this.costToHere = manhattanDistance(goal)+ parent.costToHere;
    }
    //for creating the root node, specifying the depth as 0;
    public Node(Node parent,Coord coord,int depth,Coord goal){
        this.parent = parent;
        this.coord = coord;
        this.depth = depth; //0
        this.dir = findDir();
        this.goal = goal;
        this.costToHere = this.manhattanDistance(goal); //A star initial cost of root node
    }

    public int findDir(){

        int c = this.getCoord().getC();
        int r = this.getCoord().getR();

        if(c%2 ==r%2 ){
            return 0;
        } else {
            return 1;
        }
    }

    public int manhattanDistance(Coord goal){
        int col = this.getCoord().getC();
        int row = this.getCoord().getR();
        int dir = this.findDir();

        int gcol = goal.getC();
        int grow = goal.getR();
        int gdir = goal.findDir();

        int ga = -grow;
        int gb = (grow + gcol -gdir)/2;
        int gc = (grow + gcol -gdir)/2 +(-grow + gdir);

        int a = -row;
        int b = (row + col -dir)/2;
        int c = (row + col -dir)/2 +(-row + dir);

        return Math.abs(a- ga) + Math.abs(b - gb) + Math.abs(c - gc);
    }

    public Coord getCoord(){
        return this.coord;
    }
    public int getDepth(){
        return this.depth;
    }
    public Node getParent(){
        return this.parent;
    }
    public int getDir(){
        return this.dir;
    }
    public int getCostToHere(){
        return this.costToHere;
    }
    public int getCostToGoal(){
        return this.costToGoal;
    }
}
