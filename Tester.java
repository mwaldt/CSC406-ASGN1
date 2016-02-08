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
		
		System.out.println("Reading from file: " + weightedFileName);
		ArrayList<String> weightedStrings = readFromFile(weightedFileName);
/*
		for(String s : weightedStrings){
			System.out.println(s);
		}
/**/
		System.out.println("Creating Weighted Directed Matrix");
		WeightedDirectedMatrix wdm = new WeightedDirectedMatrix(Integer.valueOf(weightedStrings.get(0)));
		System.out.println("WDM created...");
		addEdges(wdm, weightedStrings);

		System.out.println("Creating Weighted Directed List");
		WeightedDirectedList wdl = new WeightedDirectedList(Integer.valueOf(weightedStrings.get(0)));
		
		System.out.println("\n\n--------\n\n");
		System.out.println("Value of first line read in: " + Integer.valueOf(weightedStrings.get(0)));
		System.out.println("\n\n--------\n\n");

		addEdges(wdl, weightedStrings);

		System.out.println("\n------------\n");


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
		System.out.println("Enter addEdges Method...");
		int[] i = new int[3];
		/*Iterables.skip(edges, 1)/* I was having a hard time making this work for my foreach loop*/
		System.out.println("Before for loop...");
		for(String s : edges.subList(1, edges.size())){
			System.out.println("Initial String: " + s);
			i = splitInputString(s);
			System.out.println("Post Split String Method call...");
			g.putEdge(i[0], i[1], i[2]);
		}/**/
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
		 
		System.out.println(path);
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
