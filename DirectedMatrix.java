/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/


import java.util.*;

public abstract class DirectedMatrix extends DirectedGraph{

	private int[][] edgeMatrix;

	public DirectedMatrix(){
		super();
	}

	public DirectedMatrix(int verticies){
		super(verticies);
		edgeMatrix = new int[verticies][verticies];
	}

	// Returns True if and edge exists, else false
	public boolean existsEdge(Edge e){
		if( edgeMatrix[e.getSource()-1][e.getDestination()-1] == 0){
			return false;
		}else { return true; }
	}

	// Create edge for Matrix
	protected void createEdge(Edge e){
		edgeMatrix[e.getSource()-1][e.getDestination()-1] = e.getWeight();
	}

	// Remove edge for Matrix
	protected void clearEdge(Edge e){
		edgeMatrix[e.getSource()-1][e.getDestination()-1] = 0;
	}

	// Produces an array of verticies adjacent to input vertex i
	public ArrayList<Integer> adjacentVerticies(int i){
		ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
		int[] rowValues = edgeMatrix[i]; 
		for(int j = 0; j < rowValues.length; j++){
			if(rowValues[j] != 0){
				adjacentVerts.add(j);
			}
		}
		return adjacentVerts;
		//return adjacentEdges.toArray();
	}		// -mw need advice on how to better implement

	
}
