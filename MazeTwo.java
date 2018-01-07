import java.util.*;
class MazeTwo{
	static class Node{
		int posx, posy;
		int count;
		boolean visited;
		int val;
		public Node(int x, int y,int val, int count){
			this.count= count;
			posy = y;
			posx = x;
			visited = false;
			this.val = val;
		}
	};

	public static int shortestDistance(int[][] maze, int[] start, int[] dest) {
		if(maze == null || maze.length == 0){
			return -1;
		}
		int rows = maze.length;
		int cols = maze[0].length;
		Node[][] mat = new Node[rows][cols];
		boolean oppSideOpenVert = false;
		boolean oppSideOpenHori = false;
		if(dest[0] - 1 >= 0 && dest[0] +1 < rows){
			if(maze[dest[0]-1][dest[1]] == 0 && maze[dest[0]+1][dest[1]] == 0){
				oppSideOpenVert = true;
			}
		}
		if(dest[1] - 1 >= 0 && dest[1] +1 < cols){
			if(maze[dest[0]][dest[1]-1] == 0 && maze[dest[0]][dest[1]+1] == 0){
				oppSideOpenHori = true;
			}
		}
		System.out.println(oppSideOpenVert);
		System.out.println(oppSideOpenHori);
		if((!oppSideOpenHori) && (!oppSideOpenVert)){
			for(int i = 0 ; i < rows; i++){
				for(int j = 0 ; j < cols; j++){
					mat[i][j] = new Node(i, j, maze[i][j], Integer.MAX_VALUE);
				}
			}
			//bfs(start, dest);
			Queue<Node> q = new LinkedList<>();
			mat[start[0]][start[1]].count = 0;
			q.add(mat[start[0]][start[1]]);
			
			while(!q.isEmpty()){
				Node temp = q.remove();
				int[] px = {-1, 0, 1, 0};
				int[] py = {0, -1, 0, 1};
				for(int i = 0; i < 4; i++){
					int x = temp.posx + px[i];
					int y = temp.posy + py[i];
                	int cnt = 1;
                	while(x >= 0 && x < rows && y >= 0 && y < cols && mat[x][y].val != 1){
                		x += px[i];
                		y += py[i];
                		cnt++;
                	}
                	x -= px[i];
                	y -= py[i];
                	cnt--;
                	if(temp.count + cnt < mat[x][y].count){
                		mat[x][y].count = temp.count + cnt;
                		q.offer(mat[x][y]);
                	}
				}
			}
			return mat[dest[0]][dest[1]].count;			
		}

		return -1;
	}	
	public static void main(String[] args) {
		int[][] m = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
		System.out.println(shortestDistance(m,new int[]{0,4}, new int[]{3,2}));
	}
}
