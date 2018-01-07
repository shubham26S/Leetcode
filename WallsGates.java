import java.util.*;
import java.lang.*;
public class WallsGates{
	//Sol 1
	// static class MatNode{
	// 	int x, y;
	// 	boolean visited;
	// 	int val;
	// 	public MatNode(int x, int y){
	// 		val = 0;
	// 		this.x = x;
	// 		this.y = y;
	// 		visited = false;
	// 	}
	// };
	// static int row;
	// static int col;
	// static MatNode[][] mat;
	// public static void wallsAndGates(int[][] rooms){
	// 	row = rooms.length;
	// 	if(row == 0){
	// 		return;
	// 	}
	// 	col = rooms[0].length;
	// 	mat = new MatNode[row][col];
		
	// 	for(int i = 0 ; i < row; i++){
	// 		for(int j = 0 ; j < col; j++){
	// 			mat[i][j] = new MatNode(i, j);
	// 		}
	// 	}
	// 	for(int i = 0 ; i < row; i++){
	// 		for(int j = 0 ; j < col ; j++){
	// 			if(rooms[i][j] == 0){
	// 				bfs(mat[i][j], rooms);
	// 				clearVisited();
	// 			}
	// 		}
	// 	}
	// }
	// static void clearVisited(){
	// 	for(int i = 0 ; i < row; i++){
	// 		for(int j = 0 ; j < col; j++){
	// 			mat[i][j].visited = false;
	// 		}
	// 	}
	// }
	// static void bfs(MatNode node, int[][] rooms){
	// 	node.visited = true;
	// 	Queue<MatNode> q = new LinkedList<>();
	// 	q.add(node);
	// 	while(!q.isEmpty()){
	// 		MatNode temp = q.remove();
	// 		int[] X = {-1, 0, 1, 0};
	// 		int[] Y = {0, 1, 0, -1};
	// 		for(int i = 0 ; i < 4; i++){
	// 			int xval = temp.x + X[i];
	// 			int yval = temp.y + Y[i];
	// 			if(isValid(xval, yval, rooms)){
	// 				mat[xval][yval].visited = true;
	// 				if(mat[xval][yval].val != 0){
	// 					mat[xval][yval].val = Math.min(mat[xval][yval].val, temp.val+1);
	// 				}
	// 				else mat[xval][yval].val = temp.val + 1;
	// 				q.add(mat[xval][yval]);
	// 			}
	// 		} 
	// 	}
	// }

	// static boolean isValid(int x, int y, int[][] rooms){
	// 	if(x >= 0 && x < row && y >= 0 && y < col && !mat[x][y].visited && rooms[x][y] != 0 && rooms[x][y] != -1){
	// 		return true;
	// 	}
	// 	return false;
	// }

	public static void wallsAndGates(int[][] rooms) {
		if(rooms == null || rooms.length == 0){
			return;
		}
		int rows = rooms.length;
		int cols = rooms[0].length;
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0 ; i < rows; i++){
			for(int j = 0 ; j < cols ; j++){
				if(rooms[i][j] == 0){
					q.offer(new int[]{i, j});
				}
			}
		}
		while(!q.isEmpty()){
			int[] temp = q.remove();
			int row = temp[0];
			int col = temp[1];
			int[] posX = {-1, 0, 1, 0};
			int[] posY = {0, 1, 0, -1};
			for(int i=0 ;i < 4; i++){
				int xval= row+posX[i];
				int yval = col+posY[i];
				if(xval >= 0 && xval < rows && yval >= 0 && yval < cols && rooms[xval][yval] == Integer.MAX_VALUE){
					rooms[xval][yval] = rooms[row][col]+1;
					q.offer(new int[]{xval, yval});
				}
			}
			// if(row+1 >= 0 && row +1 < rows && col >= 0 && col < cols && rooms[row+1][col] == Integer.MAX_VALUE){
			// 	rooms[row+1][col] = rooms[row][col]+1;
			// 	q.offer(new int[]{row+1, col});
			// }
			// if(row-1 >= 0 && row -1 < rows && col >= 0 && col < cols && rooms[row-1][col] == Integer.MAX_VALUE){
			// 	rooms[row-1][col] = rooms[row][col]+1;
			// 	q.offer(new int[]{row-1, col});
			// }
			// if(row >= 0 && row < rows && col+1 >= 0 && col+1 < cols && rooms[row][col+1] == Integer.MAX_VALUE){
			// 	rooms[row][col+1] = rooms[row][col]+1;
			// 	q.offer(new int[]{row, col+1});
			// }
			// if(row >= 0 && row  < rows && col -1 >= 0 && col-1 < cols && rooms[row][col-1] == Integer.MAX_VALUE){
			// 	rooms[row][col-1] = rooms[row][col]+1;
			// 	q.offer(new int[]{row, col-1});
			// }
		}
	}
	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		int[][] m = {{max, -1, 0, max}, {max, max, max, -1}, {max, -1, max, -1}, {0, -1, max, max}};
		wallsAndGates(m);
		for(int i = 0 ; i < m.length; i++){
			for(int j = 0 ; j < m[0].length; j++){
				System.out.print(m[i][j] +" ");
			}
			System.out.println();
		}
	}
}