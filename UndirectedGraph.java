/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/


public abstract class UndirectedGraph extends Graph{

	public UndirectedGraph(){
		super();
	}

	public UndirectedGraph(int edges){
		super(edges);
	}
	
	// Handles incrementing of edge count,
	// Specific implementation based on type of graph
	protected void insertEdge(Edge e){
		Edge e2 = new Edge(e.getDestination(), e.getSource(), e.getWeight());
		incrementDegrees(e);
		createEdge(e);
		incrementDegrees(e2);
		createEdge(e2);
	}

	// Create edge for Matrix/list
	// Specific implementation based on type of graph
	protected abstract void createEdge(Edge e);



	// Handles decrementing of edge count,
	// Specific implementation based on type of graph
	protected  void deleteEdge(Edge e){
		Edge e2 = new Edge(e.getDestination(), e.getSource(), e.getWeight());
		decrementDegrees(e);
		cleanEdge(e);
		decrementDegrees(e2);
		cleanEdge(e2);
	}

	// Remove edge from Matrix/list
	// Specific implementation based on type of graph
	protected abstract void cleanEdge(Edge e);
}
