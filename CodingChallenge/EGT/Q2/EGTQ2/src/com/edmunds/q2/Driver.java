package com.edmunds.q2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		
		// Create a bufferedreader to open and read the file
		BufferedReader reader = null;
		
		try {
			
			reader = new BufferedReader ( new FileReader("CsvExample.csv"));
			
			// create a variable to read the file into
			String line = reader.readLine();
			
			// Loop through and parse the data
			while (( line = reader.readLine()) != null) {
				String[] words = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				for (int i = 0; i < words.length; i++) {
					 words[i] = words[i].replace("\"", "");
				}
				System.out.println(words[0] + "\n" + words[1] + "\n" + words[2] + "\n");
			}
			
		// Handle any errors
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			// once done close the reader
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

}
