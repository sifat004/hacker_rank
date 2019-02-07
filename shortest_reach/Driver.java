package shortest_reach;
import java.util.*;


public class Driver {
	public static int EDGE_WEIGHT=6;
	
	
	public static void main(String[] args) {
		
		Graph g=new Graph(9,8);
		g.addEdges(0, 1);

		g.addEdges(0, 2);
		g.addEdges(1, 4);
		g.addEdges(1, 5);
		g.addEdges(2, 6);
		g.addEdges(3, 7);
		g.addEdges(3, 6);
		g.addEdges(6, 7);
		g.addEdges(3, 8);



		
		ArrayList<Integer> res=g.shortestReachBFS(0, 7);
		ArrayList<Integer> res2=g.shortestReachDFS(0, 7);

		System.out.println("bfs");

		
		System.out.println(res);

	    System.out.println("dfs");

		
		System.out.println(res2);




	}
	
	

}
