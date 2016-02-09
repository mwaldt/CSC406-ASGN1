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

	private int[][] adjacencyMatrix;

	public DirectedMatrix(int verticies){
		super(verticies);
		adjacencyMatrix = new int[verticies][verticies];
	}

	// Returns True if and edge exists, else false
	public boolean existsEdge(Edge e){
		return !(adjacencyMatrix[e.getSource()-1][e.getDestination()-1] == 0);
	}

	// Create edge for Matrix
	protected void createEdge(Edge e){
		adjacencyMatrix[e.getSource()-1][e.getDestination()-1] = e.getWeight();
	}

	// Remove edge for Matrix
	protected void clearEdge(Edge e){
		adjacencyMatrix[e.getSource()-1][e.getDestination()-1] = 0;
	}

	// Produces an ArrayList of verticies adjacent to input vertex i
	public ArrayList<Integer> adjacentVerticies(int i){
		ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
		for(int j = 0; j < adjacencyMatrix[i].length; j++){
			if(adjacencyMatrix[i][j] != 0){
				adjacentVerts.add(j+1);
			}
		}
		return adjacentVerts;
	}
}
