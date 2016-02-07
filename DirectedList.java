/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/

import java.util.*;

public abstract class DirectedList extends DirectedGraph{

	LinkedList<Edge>[] edgeList;
	
	public DirectedList(){
		super();
		edgeList = new LinkedList<Edge>[1];
	}

	public DirectedList(int edges){
		super(edges);
		edgeList = new LinkedList<Edge>[edges];
	}

	// Returns True if and edge exists, else false
	public boolean existsEdge(Edge e){
		return edgeList[e.getSource()-1].contains(e);
	}

	// Create edge for Matrix
	protected void createEdge(Edge e){
		edgeList[e.getSource()-1].add(e);
	}

	// Remove edge for Matrix
	protected void clearEdge(Edge e){
		edgeList[e.getSource()-1].remove(e);
	}

	// Produces an array of verticies adjacent to input vertex i
	public int[] adjacentVerticies(int i){
		List<Integer> adjtVerticies = new ArrayList<Integer>();
		ListIterator<Edge> list = edgeList[i].listIterator();
		while(list.hasNext()){
			adjtVerticies.add(list.next().getDestination());
		}
		return new int[1];
	}		// -mw need advice on how to better implement
	
}
