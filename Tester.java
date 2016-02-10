/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/

import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.*;

public class Tester{

	private final String weightedFileName = "input weighted.txt";
	private final String unweightedFileName = "input unweighted.txt";
	private Scanner scanner;

	public Tester(){
		
	}

	public static void main(String args[]){
		Tester tester = new Tester();
		tester.run();
	}

	private void run(){
		System.out.println("Running test program for Graph API");
		System.out.println("\n--------\n");
		
		System.out.println("Reading from file: " + weightedFileName);
		ArrayList<String> weightedStrings = readFromFile(weightedFileName);
		System.out.println("--------");


		System.out.println("Creating Weighted Directed Matrix");
		WeightedDirectedMatrix wdm = new WeightedDirectedMatrix(Integer.valueOf(weightedStrings.get(0)));
		addEdges(wdm, weightedStrings);
		allTestsOnDirectedGraph(wdm);
		System.out.println("\n--------\n");

		System.out.println("Creating Weighted Directed List");
		WeightedDirectedList wdl = new WeightedDirectedList(Integer.valueOf(weightedStrings.get(0)));
		addEdges(wdl, weightedStrings);
		allTestsOnDirectedGraph(wdl);
		System.out.println("\n--------\n");


		System.out.println("Reading from file: " + unweightedFileName);
		ArrayList<String> unweightedStrings = readFromFile(unweightedFileName);
		System.out.println("--------");

		System.out.println("Creating Unweighted Directed Matrix");
		UnweightedDirectedMatrix uwdm = new UnweightedDirectedMatrix(Integer.valueOf(unweightedStrings.get(0)));
		addEdges(uwdm, unweightedStrings);
		allTestsOnDirectedGraph(uwdm);
		System.out.println("\n--------\n");

		System.out.println("Creating Unweighted Directed List");
		UnweightedDirectedList uwdl = new UnweightedDirectedList(Integer.valueOf(unweightedStrings.get(0)));
		addEdges(uwdl, unweightedStrings);
		allTestsOnDirectedGraph(uwdl);
		System.out.println("\n------------\n");
		
	}

	private void allTestsOnDirectedGraph(DirectedGraph g){
		//addEdgesTest(g, "1 4 5");
		getInDegreesOfGraph(g);
		getOutDegreesOfGraph(g);
		listAdjacentVerticies(g);
		removeEdgesTest(g, "5 4 4");
		testAdjacent(g, new Edge(4,5));
	}


	private void addEdges(Graph g, ArrayList<String> edges){
		int[] i = new int[3];
		for(String s : edges.subList(1, edges.size())){
			//System.out.println("Initial String: " + s);
			addEdge(g, s);
		}
		System.out.println();
	}

	private void addEdge(Graph g, String s){
		int[] i = splitInputString(s);
		//System.out.println("Post Split String Method call...");
		g.putEdge(i[0], i[1], i[2]);
	}

	private void addEdgesTest(Graph g, String s){
		System.out.println("Adding new edge ( " + s +") to graph ");
		addEdge(g, s);

		System.out.println("Attemping to add repeat edge ( " + s +") to graph ");
		addEdge(g, s);

		System.out.println();
	}



	private void removeEdge(Graph g, String s){
		int[] i = splitInputString(s);
		//System.out.println("Post Split String Method call...");
		g.removeEdge(i[0], i[1]);
	}

	private void removeEdgesTest(Graph g, String s){
		System.out.println("Adding new edge ( " + s +") to graph to be removed");
		addEdge(g, s);

		System.out.println("Removing edge ( " + s +") from graph . ");
		removeEdge(g, s);

		System.out.println("Attemping to remove edge ( " + s +") from graph again. ");
		removeEdge(g, s);

		System.out.println();
	}


	private void getInDegreesOfGraph(DirectedGraph g){
		System.out.println("Printing the in degrees of each verticie in a graph");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i+1) + ": ");
			System.out.print(g.inDegrees(i) + "\n");
		}
		System.out.println();
	}

	private void getOutDegreesOfGraph(DirectedGraph g){
		System.out.println("Printing the out degrees of each verticie in a graph");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i+1) + ": ");
			System.out.print(g.outDegrees(i) + "\n");
		}
		System.out.println();
	}
	

	private void listAdjacentVerticies(DirectedGraph g){
		System.out.println("Printing the list of all adjacent verties to each vertice in the graph.");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i+1) + ": ");
			System.out.print(g.adjacentVerticies(i).toString() + "\n");
		}
		System.out.println();
	}

	private void testAdjacent(Graph g, Edge e){
		System.out.println("Testing to see if vertices " + e.getSource() + " and " + e.getDestination() + " are adjacent.");
		if(g.existsEdge(e)){
			System.out.println("Edge " + e.toString() + " exists.");
		}else{
			System.out.println("Edge " + e.toString() + " does not exist.");
		}
		System.out.println();
	}


	private int[] splitInputString(String s){
		String[] str = s.split(" ");
		int[] ints = new int[3];
		if(str.length == 2){
			ints[2] = 1;
		}
		for(int i = 0; i < str.length; i++){
			ints[i] = Integer.parseInt(str[i]);
		}
		return ints;
	}

	private ArrayList<String> readFromFile(String fileName){
		//String line = null;
		ArrayList<String> list;
		Path path = Paths.get(fileName);
		 
		//System.out.println(path);
        try(Stream<String> lines = Files.lines(path)){
        	list = new ArrayList<String>(Arrays.asList(lines.toArray(size -> new String[size])));
        	return list;
        	//return lines.toArray(size -> new String[size]);
        	//lines.forEach(System.out::println);
        } catch (IOException ex){
        	return new ArrayList<String>();
        }

	}//end method
}//end class
