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

	protected LinkedList<Edge>[] edgeList;

	protected boolean[] listInit;
	
	public DirectedList(){
		super();
		edgeList = new LinkedList[1];
		listInit = new boolean[1];
	}


	public DirectedList(int verticies){
		super(verticies);
		edgeList = new LinkedList[verticies];
		listInit = new boolean[verticies];
		for(int i = 0; i < edgeList.length; i++){
			edgeList[i] = new LinkedList<Edge>();
		}
	}

	// Returns True if and edge exists, else false
	public boolean existsEdge(Edge e){
		System.out.println("Entering existsEdge method in DirectedList class");
		System.out.println(listInit[e.getSource()-1]);
		if( !(listInit[e.getSource() - 1]) ){
			System.out.println("Empty LinkedList: ");
			listInit[e.getSource()-1] = true;
			return false;
		} else{
			System.out.println("LinkedList has elements");
			return edgeList[e.getSource()-1].contains(e);
		}
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
	public ArrayList<Integer> adjacentVerticies(int i){
		ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
		ListIterator<Edge> list = edgeList[i].listIterator();
		while(list.hasNext()){
			adjacentVerts.add(list.next().getDestination());
		}
		return adjacentVerts;
	}		// -mw need advice on how to better implement
	
}
