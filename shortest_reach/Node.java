package shortest_reach;
import java.util.*;

public class Node {
	
	int index;
	ArrayList<Node> neighbours;
	boolean explored;
	int distance;
	Node parent;
	
	Node(int index)
	{
		
		this.index=index;
		neighbours=new ArrayList<>();
		
	}
	
	public void setParent(Node n) {
		this.parent=n;
	}
	public Node getParent() {
		
		return this.parent;
	}
	
	public int getIndex() {
		
		return this.index;
	}
	
	public void addNeigbour(Node n) 
	{
		
		neighbours.add(n);
	}
	
	public ArrayList<Node> getNeighbours(){
		return this.neighbours;
	}
	
	public void setExplored(boolean b) {
		this.explored=b;
	}
	
	public boolean isExplored() {
		return this.explored;
	}
	
	
	public int getDistance() {
		
		return this.distance;
	}
	
	public void setDistance(int d) {
		
		this.distance=d;
	}

}
