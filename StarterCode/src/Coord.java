/********************Starter Code
 * 
 * This represents the coordinate data structure (row, column)
 * and prints the required output
 *
 *
 * @author at258
 *   
 */

public class Coord {
	private int r;//row
	private int c;//column

	public Coord(int row,int column) {
		r=row;
		c=column;
	}

	public String toString() {
		return "("+r+","+c+")";
	}

	public int getR() {
		return r;
	}
	public int getC() {
		return c;
	}

	@Override
	public boolean equals(Object o) {

		Coord coord=(Coord) o;
		if(coord.r==r && coord.c==c) {
			return true;
		}
		return false; 

	}

	public int findDir(){
		c = this.c;
		r = this.r;
		//pointing up
		if(c%2 == 0 && r%2 == 0 || c%2==1 && r%2==1){
			return 0;
		} else {
			//pointing down
			return 1;
		}
	}

}
