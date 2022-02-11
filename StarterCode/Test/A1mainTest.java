
import org.junit.jupiter.api.Test;

public class A1mainTest extends A1main {

    @Test
    public void mainTest1(){
        String[] args = {"BFS","JCONF00"};
        //main(args);
    }
    @Test
    public void mainTest2(){
        String[] args = {"DFS","JCONF00"};
        //main(args);
    }
    @Test
    public void mainTest3(){
        String[] args = {"BestF","JCONF00"};
       // main(args);
    }
    @Test
    public void mainTest4(){
        String[] args = {"AStar","JCONF02"};
        main(args);
    }
    @Test
    public void mainTest5(){
        String[] args = {"BFS","JCONF02"};
        main(args);
    }


}