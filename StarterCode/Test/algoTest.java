import org.junit.Test;

public class algoTest {

    @Test
    public void test1() {

        for (Conf conf : Conf.values()) {
            System.out.println("Configuration:" + conf);
            Map map = conf.getMap();
            Coord start = conf.getS();
            Coord goal = conf.getG();

            BFS b = new BFS(map, start, goal);

        }
    }

    @Test
    public void test2() {

        for (Conf conf : Conf.values()) {
            System.out.println("Configuration:" + conf);
            Map map = conf.getMap();
            Coord start = conf.getS();
            Coord goal = conf.getG();

            //DFS b = new DFS(map, start, goal);

        }
    }

    @Test
    public void test3() {

        for (Conf conf : Conf.values()) {
            System.out.println("Configuration:" + conf);
            Map map = conf.getMap();
            Coord start = conf.getS();
            Coord goal = conf.getG();
           // BestF b = new BestF(map, start, goal);//
        }
    }

    @Test
    public void test4() {

        for (Conf conf : Conf.values()) {
            System.out.println("Configuration:" + conf);
            Map map = conf.getMap();
            Coord start = conf.getS();
            Coord goal = conf.getG();
            //AStar b = new AStar(map, start, goal);//

        }

    }
    @Test
    public void test5() {

        for (Conf conf : Conf.values()) {
            System.out.println("Configuration:" + conf);
            Map map = conf.getMap();
            Coord start = conf.getS();
            Coord goal = conf.getG();
            //DirectionalSearch b = new DirectionalSearch(map, start, goal);//

        }

    }



}
