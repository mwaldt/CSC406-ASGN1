/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/


public abstract class DirectedGraph extends Graph{
	
	protected int[] inDegrees;
	protected int[] outDegrees;
/*
	protected void initDirectedGraph(int verticies){
		initGraph(verticies);
		inDegrees = new int[verticies];
		outDegrees = new int[verticies];
	}
/**/	
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


	// Increase inDegree and outDegree based on input edge src and dest
	protected void incrementDegrees(Edge e){
		inDegrees[e.getDestination()-1]++;
		outDegrees[e.getSource()-1]++;
	}
	
	// Decrease inDegree and outDegree based on input edge src and dest
	protected void decrementDegrees(Edge e){
		inDegrees[e.getDestination()-1]--;
		outDegrees[e.getSource()-1]--;
	}

	protected int inDegree(int i){
		return inDegrees[i];
	}
	
	protected int iutDegree(int i){
		return outDegrees[i];
	}


}
