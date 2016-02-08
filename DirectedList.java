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

	protected LinkedList<Edge>[] adjacencyList;

	public DirectedList(int verticies){
		super(verticies);
		adjacencyList = new LinkedList[verticies];
		for(int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new LinkedList<Edge>();
		}
	}

	// Returns True if and edge exists, else false
	public boolean existsEdge(Edge e){
		//System.out.println("Entering existsEdge method in DirectedList class");
		//System.out.println(listInit[e.getSource()-1]);
		return adjacencyList[e.getSource()-1].contains(e);
	}

	// Create edge for List
	protected void createEdge(Edge e){
		adjacencyList[e.getSource()-1].add(e);
	}

	// Remove edge for List
	protected void clearEdge(Edge e){
		adjacencyList[e.getSource()-1].remove(e);
	}

	// Produces an array of verticies adjacent to input vertex i
	public ArrayList<Integer> adjacentVerticies(int i){
		ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
		ListIterator<Edge> list = adjacencyList[i].listIterator();
		while(list.hasNext()){
			adjacentVerts.add(list.next().getDestination());
		}
		return adjacentVerts;
	}		// -mw need advice on how to better implement
	
}
