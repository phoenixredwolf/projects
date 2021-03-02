package com.edmunds.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	public static void main(String[] args) throws IOException {
		int action;
		String test;
		boolean validInput;
		String number;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean quit = false;
		String sub1;
		String sub2;
		String sub3;
		
		while (!quit) {
			
			// give the user their options and get their input
			menu();
			validInput = false;
			test = in.readLine();
			
			// Check if Q was pressed
			if (test.equals("Q")) {
				System.out.println("Thank you! Good bye!");
				quit = true;
				continue;
			}
			
			
			// Check the input to ensure only integers
			while (!validInput) {
				validInput = isInteger(test);
				if (!validInput) {
					test = in.readLine();
					validInput = isInteger(test);
				}
			}
			
			// Convert proper input to an integer
			action = Integer.parseInt(test);
			
			if (action == 1 ) {
				
				// get the phone number
				System.out.println("Please enter phone number.");
				number = in.readLine();
				
				// If proper length, format it
				if (number.length() == 10) {
					
					sub1 = number.substring(0,3);
					sub2 = number.substring(3,6);
					sub3 = number.substring(6);
					
					System.out.println("(" + sub1 + ")" + sub2 + "-" + sub3 + "\n");
					
				} else {
					
					// If not, print error
					System.out.println("Error! Phone numbers should be 10 digits long.\n");
				}
			} else if (action == 2) {
				
				// Get the ssn
				System.out.println("Please enter the ssn.");
				number = in.readLine();
				
				// If proper length, format it
				if (number.length() == 9) {
					
					sub1 = number.substring(0,3);
					sub2 = number.substring(3,5);
					sub3 = number.substring(5);
					
					System.out.println(sub1 + "-" + sub2 + "-" + sub3 + "\n");
					
				} else {
					
					// if not, throw error
					System.out.println("Error! Social security numbers should be 9 digits long.\n");
				}
			}else {
				
				System.out.println("Invalid entry, please try again\n");
				continue;
				
			}
			
		}
		
		in.close();			
				
	}
	
	public static void menu() {
		
		System.out.println("1. Enter a phone number.");
		System.out.println("2. Enter a ssn.");
		System.out.println("Press Q to Quit.\n");
	
	}
	
   public static boolean isInteger(String s) {
	      boolean isValidInteger = false;

	      
	      try
	      {
	         Integer.parseInt(s);
	 
	         // s is a valid integer
	 
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	         System.out.println("Only numbers are accepted as a valid entry. Please try again.");
	         System.out.println("Please enter a valid number: ");
	         
	      }
	 
	      return isValidInteger;
	   }
}
