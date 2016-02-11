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

	LinkedList<Edge>[] adjacencyList;

	// Sets up the Matrix
	void setUpDataType(){
		adjacencyList = new LinkedList[vertexCount];
		for(int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new LinkedList<Edge>();
		}
	}

	// Returns True if and edge exists, else false
	boolean existsEdge(Edge e){
		return adjacencyList[e.getSource()-1].contains(e);
		/*
		ListIterator<Edge> list = adjacencyList[e.getSource()-1].listIterator();
		boolean matchFound = false;
		while(list.hasNext() && !(matchFound)){
			matchFound = list.next().equals(e);
		}
		
		return matchFound;	*/
	}

	// Create edge for List
	void createEdge(Edge e){
		adjacencyList[e.getSource()-1].add(e);
	}

	// Remove edge for List
	void clearEdge(Edge e){
		adjacencyList[e.getSource()-1].remove(e);
	}

	// Produces an array of verticies adjacent to input vertex i
	ArrayList<Integer> adjacentVerticies(int i){
		ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
		ListIterator<Edge> list = adjacencyList[i].listIterator();
		while(list.hasNext()){
			adjacentVerts.add(list.next().getDestination());
		}
		return adjacentVerts;
	}

	@Override
	public String toString(){
		String out = "";
		for(int i = 0; i < adjacencyList.length; i++){

		}
		return out;
	}
	
}
