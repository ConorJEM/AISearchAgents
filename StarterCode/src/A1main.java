/********************Starter Code
 * 
 * This class contains some examples on how to handle the required inputs and outputs 
 * and other debugging options
 * 
 * @author at258
 * 
 * run with 
 * java A1main <Algo> <ConfID>
 * 
 */


public class A1main {

	public static void main(String[] args) {

		String search = args[0];
		Conf conf = Conf.valueOf(args[1]);

		//Uncomment here for debugging only
//
//		System.out.println("Configuration:" + conf);
//		System.out.println("Map:");
//		printMap(conf.getMap(), conf.getS(), conf.getG());
//		System.out.println("Departure port: Start (r_s,c_s): "+conf.getS());
//		System.out.println("Destination port: Goal (r_g,c_g): "+conf.getG());
//		System.out.println("Search algorithm: "+args[0]);
//		System.out.println("Search algorithm: " + search);
//		System.out.println();

		runSearch(search,conf.getMap(),conf.getS(),conf.getG());

	}

	private static void runSearch(String algo, Map map, Coord start, Coord goal) {
		switch(algo) {
		case "BFS": //run BFS
			new BFS(map, start, goal);
			break;
		case "DFS": //run DFS
			new DFS(map,start,goal);
			break;  
		case "BestF": //run BestF
			new BestF(map,start,goal);
			break;
		case "AStar": //run AStar
			new AStar(map,start,goal);
			break;

			case "DirectionalSearch"://run directional search
			new DirectionalSearch(map,start,goal);
			break;
		}

	}

	private static void printMap(Map m, Coord init, Coord goal) {

		int[][] map=m.getMap();

		System.out.println();
		int rows=map.length;
		int columns=map[0].length;

		//top row
		System.out.print("  ");
		for(int c=0;c<columns;c++) {
			System.out.print(" "+c);
		}
		System.out.println();
		System.out.print("  ");
		for(int c=0;c<columns;c++) {
			System.out.print(" -");
		}
		System.out.println();

		//print rows 
		for(int r=0;r<rows;r++) {
			boolean right;
			System.out.print(r+"|");
			if(r%2==0) { //even row, starts right [=starts left & flip right]
				right=false;
			}else { //odd row, starts left [=starts right & flip left]
				right=true;
			}
			for(int c=0;c<columns;c++) {
				System.out.print(flip(right));
				if(isCoord(init,r,c)) {
					System.out.print("S");
				}else {
					if(isCoord(goal,r,c)) {
						System.out.print("G");
					}else {
						if(map[r][c]==0){
							System.out.print(".");
						}else{
							System.out.print(map[r][c]);
						}
					}
				}
				right=!right;
			}
			System.out.println(flip(right));
		}
		System.out.println();


	}

	private static boolean isCoord(Coord coord, int r, int c) {
		//check if coordinates are the same as current (r,c)
		if(coord.getR()==r && coord.getC()==c) {
			return true;
		}
		return false;
	}

	public static String flip(boolean right) {
        //prints triangle edges
		if(right) {
			return "\\"; //right return left
		}else {
			return "/"; //left return right
		}

	}

}
