package com.edmunds.q1;

import javax.swing.SwingUtilities;

public class Driver {
		

	public static void main(String[] args) {

		// Let the interface do the work
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					UserInterface ui = new UserInterface();
				}
			});


	}

}
