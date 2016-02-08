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
/*
		for(String s : weightedStrings){
			System.out.println(s);
		}
/**/
		System.out.println("Creating Weighted Directed Matrix");
		WeightedDirectedMatrix wdm = new WeightedDirectedMatrix(Integer.valueOf(weightedStrings.get(0)));
		addEdges(wdm, weightedStrings);

		// Arbitrary edge known not to be in graph
		addEdgesTest(wdm, "1 4 5");

		System.out.println("Creating Weighted Directed List");
		WeightedDirectedList wdl = new WeightedDirectedList(Integer.valueOf(weightedStrings.get(0)));
		
		System.out.println("\n--------\n");

		System.out.println("Reading from file: " + unweightedFileName);
		ArrayList<String> unweightedStrings = readFromFile(unweightedFileName);

		System.out.println("Creating Unweighted Directed Matrix");
		UnweightedDirectedMatrix uwdm = new UnweightedDirectedMatrix(Integer.valueOf(unweightedStrings.get(0)));
		addEdges(uwdm, unweightedStrings);

		System.out.println("Creating Unweighted Directed List");
		UnweightedDirectedList uwdl = new UnweightedDirectedList(Integer.valueOf(unweightedStrings.get(0)));
		addEdges(uwdl, unweightedStrings);

		System.out.println("\n------------\n");
/*
		for(String s : readFromFile(weightedFileName)){
			System.out.println(s);
		}
/**/
		
	}


	private void addEdges(Graph g, ArrayList<String> edges){
		int[] i = new int[3];
		for(String s : edges.subList(1, edges.size())){
			//System.out.println("Initial String: " + s);
			addEdge(g, s);
		}
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
	}


	private void getInDegreesOfGraph(Graph g){
		System.out.println("Printing the indegrees of each verticie in a graph");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.println("Verticies adjacent to " + i + ": ");
			System.out.println(g.adjacentVerticies(i).toString());
		}
	}

	private void getIndegreeOfVertex(int i){

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
