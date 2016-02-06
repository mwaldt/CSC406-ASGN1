/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/
public abstract class Graph{


	protected int verticiesCount;
	protected int edgesCount;
	
	private int[] inDegrees;
	private int[] outDegrees;

	public Graph(){
		edgesCount = 0;
		verticiesCount = 0;
	}

	public Graph(int edges){
		edgesCount = edges;
		verticiesCount = 0;
		inDegrees = new int[edges];
		outDegrees = new int[edges];	
	}
	
	// Returns number of vertices in graph
	public int numVertices(){
		return verticiesCount;
	}
	
	// Returns number of edges in graph
	public int numEdges(){
		return edgesCount;
	}


	// Returns True if and edge exists, else false
	// Input edge class object
	public abstract boolean existsEdge(Edge e);

	// Returns True if and edge exists, else false
	// Input ints source and destination
	public boolean existsEdge(int src, int dest){
		return existsEdge(new Edge(src, dest));
	}



	// Adds an edge e to the graph if it doesn't already exist.
	// Input edge class object
	public void putEdge(Edge e){
		if(existsEdge(e)){
			System.out.println("Edge already exists, no duplicates.");
		}else{
			insertEdge(e);
		}
	}

	// Adds an edge e to the graph if it doesn't already exist.
	// Input ints source and destination
	public void putEdge(int src, int dest){
		putEdge(new Edge(src, dest));
	}

	// Handles actual insertion of an edge,
	// Specific implementation based on type of graph
	protected abstract void insertEdge(Edge e);
	


	// Removes an edge e from the graph if it exists.
	// Input edge class object
	public void removeEdge(Edge e){
		if(existsEdge(e)){
			deleteEdge(e);
		}else{
			System.out.println("Edge does not exist.");
		}
	}

	// Removes an edge e from the graph if it exists.
	// Input ints source and destination
	public void removeEdge(int src, int dest){
		removeEdge(new Edge(src, dest));
	}

	// Handles actual removal of an edge,
	// Specific implementation based on type of graph
	protected abstract void deleteEdge(Edge e);



	// Produces an array of verticies adjacent to input vertex i
	// Implemented in sub classes
	public abstract int[] adjacentVerticies(int i);

	// Checks to see if an edge exists from vertex i to vertex j
	public boolean areAdjacent(int i, int j){
		return existsEdge(new Edge(i, j));
	}
	
	// Increase inDegree and outDegree based on input edge src and dest
	protected void incrementDegrees(Edge e){
		inDegrees[e.getDestination()]++;
		outDegrees[e.getSource()]++;
	}
	
	// Decrease inDegree and outDegree based on input edge src and dest
	protected void decrementDegrees(Edge e){
		inDegrees[e.getDestination()]--;
		outDegrees[e.getSource()]--;
	}
	
	
}
