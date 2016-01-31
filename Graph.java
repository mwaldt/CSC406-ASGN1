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

	public Graph(){

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
	private abstract void insertEdge();
	
	// Removes an edge e from the graph if it exists.
	// Input edge class object
	public void removeEdge(Edge e){
		if(existsEdge(e)){
			deleteEdge(e);
		}else{
			System.out.println("Edge does not exist.");
		}
	}

	// Handles actual removal of an edge,
	// Specific implementation based on type of graph
	private abstract void deleteEdge();

	// Removes an edge e from the graph if it exists.
	// Input ints source and destination
	public void removeEdge(int src, int dest){
		removeEdge(new Edge(src, dest));
	}

	//
	//
	public int[] adjacentVerticies(int i){

	}

	//
	//
	public boolean areAdjacent(int i, int j){
		
	}

}
