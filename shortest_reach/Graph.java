package shortest_reach;

import java.util.*;

public class Graph {
	
	int vertices,edges;
	ArrayList<Node> nodes;
	public static int EDGE_WEIGHT=6;
	Graph(int v,int e){
		
		this.vertices=v;
		this.edges=e;
		this.nodes= new ArrayList<>();
		
		
		for(int i=0;i<v;i++) {
			nodes.add(new Node(i));
		}
		
	}
	
	
	public void addEdges(int n1,int n2) {
		
		getNode(n1).addNeigbour(getNode(n2));
		getNode(n2).addNeigbour(getNode(n1));

	}
	
	public Node getNode(int index) {
		
		for(Node n: nodes)
		{
			if(n.index==index) return n;
		}
		
		return null;
	}
	
	
	public int getArrayIndexOfNode(Node n) {
		
		for(int i=0;i<nodes.size();i++) {
			if(nodes.get(i).getIndex()==n.getIndex()) return i;
		}
		
		return -1;
	}
	
	public ArrayList<Integer> shortestReachBFS(int src,int dest){
		
		Node nSrc= getNode(src);
		Node nDest= getNode(dest);
		
		Queue<Node> queue= new LinkedList<>();
		queue.add(nSrc);
		getNode(src).setDistance(0);
		getNode(src).setParent(null);


		
		while(!queue.isEmpty()) {
			
			Node n=queue.poll();
		
			
			n.setExplored(true);
			
			for(Node neighbour:n.getNeighbours()) {
				if(!neighbour.isExplored())
				{
					neighbour.setDistance(neighbour.getDistance()+EDGE_WEIGHT);
					neighbour.setParent(n);

					queue.add(neighbour);
					
					if(neighbour.getIndex()==dest) 
						{
						while(!queue.isEmpty())       //remove other nodes from the queue to end the while loop
							queue.poll();
						break;
						}

				}
				
				
			}
				
			
		}
		
		ArrayList<Integer> pathList=new ArrayList<>();
		ArrayList<Integer> revPathList=new ArrayList<>(); 

		Node node=getNode(dest);
		while(node.getParent()!=null) 
		{
			
			pathList.add(node.getIndex());

			node=node.getParent();
			
		}
		
		for(int i=pathList.size()-1;i>=0;i--)
			revPathList.add(pathList.get(i));
		
		return revPathList;
		
		
	}
	
	
	
public ArrayList<Integer> shortestReachDFS(int src,int dest){
		
		Node nSrc= getNode(src);
		Node nDest= getNode(dest);
		
		Stack<Node> stack= new Stack<>();
		stack.push(nSrc);
		getNode(src).setDistance(0);
		getNode(src).setParent(null);

		
		while(!stack.isEmpty()) {
			
			Node n=stack.pop();
			//int i=getArrayIndexOfNode(n);
			//nodes.get(i).setExplored(true);
			
			n.setExplored(true);
			
			for(Node neighbour:n.getNeighbours()) {
				if(!neighbour.isExplored())
				{
					neighbour.setDistance(neighbour.getDistance()+EDGE_WEIGHT);
					neighbour.setParent(n);

					stack.push(neighbour);
					
					if(neighbour.getIndex()==dest) 
						{
						while(!stack.isEmpty())       //remove other nodes from the queue to end the while loop
							stack.pop();
						break;
						}

				}
				
				
			}
				
			
		}
		
		ArrayList<Integer> pathList=new ArrayList<>();
		ArrayList<Integer> revPathList=new ArrayList<>(); 

		Node node=getNode(dest);
		while(node.getParent()!=null) 
		{
			
			pathList.add(node.getIndex());

			node=node.getParent();
			
		}
		
		for(int i=pathList.size()-1;i>=0;i--)
			revPathList.add(pathList.get(i));
		
		return revPathList;
		
		
	}

}
