import java.util.*;
public class GoodRobotPath{
	public static ArrayList<Point> getPath(boolean[][] maze){
		if(maze==null||maze[0].length==0){
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		ArrayList<Point> failPoints = new ArrayList<Point>();
		if(getPath(maze,maze.length-1,maze[0].length-1,path,failPoints)){
			return path;
		}
		return null;
	}

	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, ArrayList<Point> failPoints){
		if(row<0||col<0||!maze[row][col]){
			return false;
		}
		Point p = new Point(row,col);
		if(failPoints.contains(p)){
			return false;
		}
		boolean isAtOrigin = (row==0)&&(col==0);
		if(isAtOrigin||getPath(maze,row-1,col,path,failPoints)||getPath(maze,row,col-1,path,failPoints)){
			path.add(p);
			return true;
		}
		failPoints.add(p);
		return false;
	}
	public static void main(String args[]){
		boolean[][] maze = {{true,false,false},{true,true,true},{false,false,true}};
		ArrayList<Point> path = getPath(maze);
		try{
			for(Point c:path){
				System.out.print(c.row);
				System.out.print(" ");
				System.out.println(c.col);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

class Point{
	int row, col;
	Point(int r, int c){
		this.row = r;
		this.col = c;
	}
}