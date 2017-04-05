import java.util.*;
public class RouteBetweenNodes{
	enum State {unvisited, visited, visiting};
	public static boolean search(Graph g, Node start, Node end){
		if(start==end){
			return true;
		}
		LinkedList <Node> q = new LinkedList<Node>();

		for(Node u: g.getNodes()){
			u.state = State.unvisited;
		}
		start.state = State.visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()){
			u = q.removeFirst();
			if(u!=null){
				for(Node v: u.getAdjacent()){
					if(v.state == State.unvisited){
						if(v==end){
							return true;
						}
						else{
							v.state = State.visiting;
							q.add(v);
						}
					}
				}
			}
			u.state = State.visited;
		}
		return false;
	}
	public static void main(String args[]){
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g,start,end));
	}

	public static Graph createNewGraph(){
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
}

class Node{
	private Node[] adjacent;
	public int adjacentCount;
	private String vertex;
	public RouteBetweenNodes.State state;

	public Node(String vertex, int adjacentLength){
		this.vertex = vertex;
		this.adjacentCount = 0;
		adjacent = new Node[adjacentLength];
	}

	public void addAdjacent(Node x){
		if(adjacentCount<adjacent.length){
			this.adjacent[adjacentCount] = x;
			adjacentCount+=1;
		}
		else{
			System.out.println("No more adjacent elements can be present.");
		}
	}

	public Node[] getAdjacent(){
		return adjacent;
	}
	public String getVertex(){
		return vertex;
	}
}

class Graph{
	public static int MAX_VERTICES = 6;
	private Node[] vertices;
	public int count;
	public Graph() {
		vertices = new Node[MAX_VERTICES];
		count = 0;
    }

    public void addNode(Node x){
    	if (count<vertices.length){
    		vertices[count] = x;
    		count+=1;
    	}
    	else{
    		System.out.println("Graph is over.");
    	}
    }

    public Node[] getNodes(){
    	return vertices;
    }
}