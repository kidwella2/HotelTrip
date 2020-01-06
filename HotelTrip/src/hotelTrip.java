/*
 * Name: Austin Kidwell
 * Description: This file reads in a list of numbers from a 
 * text file. Then, finds the sequence of number that has the 
 * smallest penalty. Penalty is calculated by the difference 
 * between 200 and the number advanced to squared. The results  
 * are sent to a text file.
 */

import java.util.*;
import java.io.*;

public class hotelTrip {

	public static void main(String[] args) throws FileNotFoundException {
		// Scan in text file
		Scanner dataFile = new Scanner(new File("HW1Data.txt"));
		int penalty = 0, currentStop = 0;
		//int inc = 1;
		ArrayList<Integer> hotels = new ArrayList<>();
		ArrayList<Integer> stops = new ArrayList<>();
		hotels.add(0); // optional line
		stops.add(0);
		// Loop to transfer numbers from text file to ArrayList
		while (dataFile.hasNextLine())
			hotels.add(dataFile.nextInt());
		dataFile.close();
		double h1 = Math.pow(200-(hotels.get(1)-hotels.get(0)), 2);
		double h2 = Math.pow(200-(hotels.get(2)-hotels.get(0)), 2);;
		
		// Here is code for writing to a text file.
		PrintWriter outputFile = new PrintWriter("HW1Output.txt");
		outputFile.println("Distance: " + hotels.get(currentStop) + " Total Penalty: "
				+ penalty);
		for(int i=2; i<hotels.size()-2; i++) {
			if(h1 < h2) {
				//inc = 1;
				stops.add(i-1);
				currentStop = i-1;
				penalty+=h1;
				//System.out.println(i-1 + ": " + hotels.get(currentStop) + "- "
				//		+ h1 + " < " + h2 + "\t" + penalty);
				outputFile.println("Distance: " + hotels.get(currentStop) + " Total Penalty: "
						+ penalty);
				
			}
			h1 = Math.pow(200-(hotels.get(i)-hotels.get(currentStop)), 2);
			h2 = Math.pow(200-(hotels.get(i+1)-hotels.get(currentStop)), 2);
		}
		h1 = Math.pow(200-(hotels.get(hotels.size()-2)-hotels.get(currentStop)), 2);
		penalty+=h1;
		outputFile.println("Distance: " + hotels.get(hotels.size()-2) 
		+ " Total Penalty: " + penalty);
		outputFile.close();
	}

}
