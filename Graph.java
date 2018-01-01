import java.util.*;
class Graph{
	static private int V;   // No. of vertices
	static private LinkedList<Integer> adj[]; //Adjacency List
	public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v, int w){
    	adj[v].add(w);
    }

	static boolean bfs(int a, int b){
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		visited[a] = true;
		while(!q.isEmpty()){
			int temp = q.remove();
			Iterator<Integer> i = adj[temp].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(n == b){
					return true;
				}
				if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                }

			}

		} 
		return false;
	}

	public static void main(String args[]){
		Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        int u = 1;
        int v = 3;
        if (g.bfs(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);
 
        u = 3;
        v = 1;
        if (g.bfs(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);
	}
}
// private class GNode{
// 	int val;
// 	boolean visited;
// 	int x, y;
// 	private GNode(int x, int y, int val){
// 		this.x = x;
// 		this.y = y;
// 		this.val = val;
// 		vitied = false;
// 	}
// }