package com.edmunds.q1;

import java.util.ArrayList;

public class IDs implements IDable {
	
	// Define variables
	private int baseID = 5;
	private String idString;
	private ArrayList<String> id = new ArrayList<String>();

	public IDs() {	}

	// Define createID method
	public String createID(String name) {
		
		// Prepare the name for use in the id
		int idNumber = baseID;
		name = name.toUpperCase();
		name = name.substring(0,3);
		
		// Append an id number to the prepared name
		idString = name + String.format("%03d", idNumber);
		
		/* Check if created id already exists
		 * If so, increment id number and check again
		 */
		while (id.contains(idString)) {
			idNumber += 5;
			idString = name + String.format("%03d", idNumber);
			
		}
		
		// Add new id to arraylist
		id.add(idString);
		return idString;

	}




}
