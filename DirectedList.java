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

	LinkedList[] edgeList;
	
	public DirectedList(){
		super();
		edgeList = new LinkedList[1];
	}

	public DirectedList(int edges){
		super(edges);
		edgeList = new LinkedList[edges];
	}

	// Returns True if and edge exists, else false
	public boolean existsEdge(Edge e){
		return edgeList[e.getSource()].contains(e);
	}

	// Create edge for Matrix
	protected void createEdge(Edge e){
		edgeList[e.getSource()].add(e);
	}

	// Remove edge for Matrix
	protected void cleanEdge(Edge e){
		edgeList[e.getSource()].remove(e);
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
