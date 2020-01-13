package car;

import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) {
		
		//Setup scanner for user input
		Scanner in = new Scanner(System.in);
		
		//Instantiate car object
		Mercedes myCar = new Mercedes(2020, "Mercedes");		
		
		//Begin the simulation
		System.out.println("Welcome to the car simulator.\n"
				+ "Here's your car today:\n");
		myCar.describe();
		
		System.out.println("Now that you are in your new car, what would you like to do?");
		System.out.println("Press 1 to start the car and 0 to exit");
		int action = in.nextInt();
		if (action == 1) {
			myCar.start();
			myCar.status();
		} else {
			System.out.println("Thank you for playing.  Have a nice day.");
			in.close();
			System.exit(0);
		}
		
		System.out.println("Press 1 to accelerate.");
		System.out.println("Press 0 to turn car off and exit.");
		action = in.nextInt();
		if (action == 1) {
			myCar.accelerate();
		} else {
			System.out.println("Thank you for playing.  Have a nice day.");
			in.close();
			System.exit(0);
		}
		
		//Loop to do something with the car
		while (action != 0) {
			while (myCar.engine.getSpeed() > 0) {
			System.out.println("Press 1 to Accelerate.");
			System.out.println("Press 2 to Brake.");
			action = in.nextInt();
			if (action == 1) {
				myCar.accelerate();
			}
			if (action == 2) {
				myCar.brake();
			}
			}
			System.out.println("Press 1 to Accelerate.");			
			System.out.println("Press 0 to exit.");	
			action = in.nextInt();
			if (action == 1) {
				myCar.accelerate();
			}
		}
		
		//Close our scanners and exit the program
		System.out.println("We hope you enjoy your new car.  Have a nice day.");
		in.close();
		System.exit(0);
		
	}

}
