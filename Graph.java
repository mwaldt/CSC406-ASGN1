/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/

import java.util.*;

public abstract class Graph{


	protected int vertexCount;
	protected int edgeCount;

	public Graph(int verticies){
		vertexCount = verticies;
		edgeCount = 0;	
	}
	
	// Returns number of vertices in graph
	public int numVertices(){
		return vertexCount;
	}
	
	// Returns number of edges in graph
	public int numEdges(){
		return edgeCount;
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
			System.out.println("Edge " + e.toString() + " inserted successfully.");
		}
	}

	// Adds an edge e to the graph if it doesn't already exist.
	// Input ints source, destination and weight
	public void putEdge(int src, int dest, int wght){
		putEdge(new Edge(src, dest, wght));
	}

	// Adds an edge e to the graph if it doesn't already exist.
	// Input ints source and destination, weight is implied at 1
	public void putEdge(int src, int dest){
		putEdge(new Edge(src, dest, 1));
	}

	// Handles actual insertion of an edge,
	// Specific implementation based on type of graph
	protected abstract void insertEdge(Edge e);
	


	// Removes an edge e from the graph if it exists.
	// Input edge class object
	public void removeEdge(Edge e){
		if(existsEdge(e)){
			deleteEdge(e);
			System.out.println("Edge " + e.toString() + " removed successfully.");
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
	public abstract ArrayList<Integer> adjacentVerticies(int i);

	// Checks to see if an edge exists from vertex i to vertex j
	public boolean areAdjacent(int i, int j){
		return existsEdge(new Edge(i, j));
	}
}
