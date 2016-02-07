/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/


public abstract class DirectedGraph extends Graph{

	public DirectedGraph(){
		super();
	}

	public DirectedGraph(int edges){
		super(edges);
	}
	
	// Handles incrementing of edge count,
	// Specific implementation based on type of graph
	protected void insertEdge(Edge e){
		incrementDegrees(e);
		createEdge(e);
	}

	// Create edge for Matrix/list
	// Specific implementation based on type of graph
	protected abstract void createEdge(Edge e);



	// Handles decrementing of edge count,
	// Specific implementation based on type of graph
	protected void deleteEdge(Edge e){
		decrementDegrees(e);
		clearEdge(e);
	}

	// Create edge for Matrix/list
	// Specific implementation based on type of graph
	protected abstract void clearEdge(Edge e);


}
