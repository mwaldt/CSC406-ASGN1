/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Tester{

	private final String weightedFileName = "input weighted.txt";
	private final String unweightedFileName = "input unweighted.txt";

	public Tester(){
		
	}

	public static void main(String args[]){
		Tester tester = new Tester();
		tester.run();
	}

	private void run(){
		System.out.println("Running test program for Graph API");
		
		System.out.println("Reading from file: " + weightedFileName);
		
		for(String s : readFromFile(weightedFileName)){
			System.out.println(s);
		}
		
		System.out.println("");

		//System.out.println("Reading from file: " + unweightedFileName);
		//readFromFile(unweightedFileName);
		System.out.println("");
	}

	private String[] readFromFile(String fileName){
		//String line = null;
		Path path = Paths.get(fileName);
		 
		System.out.println(path);
        try(Stream<String> lines = Files.lines(path)){
        	return lines.toArray(size -> new String[size]);
        	//lines.forEach(System.out::println);
        } catch (IOException ex){
        	return new String[0];
        }

        /*
        try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			bufferedReader.close();
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		}catch(IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}/**/
	}//end method
}//end class
