package parts;

import java.util.concurrent.TimeUnit;

public class Engine extends CarParts implements Functional {

	
	private int numCylanders;
	private FuelType fuel;
	private int rpms;
	private int speed;
		
	public Engine(int numCylanders, FuelType fuel) {
		this.numCylanders = numCylanders;
		this.fuel = fuel;
	}
	
	public int getCylanders() {
		return numCylanders;
	}
	
	public FuelType getFuel() {
		return fuel;
	}
	
	@Override
	public void status() {
		int cond = getCond();
		if (cond >= 90) {
			System.out.println("Engine is in excellent condition.");
		} else if (cond >= 80 && cond < 90){
			System.out.println("Engine is in good condition.");
		} else if (cond >= 70 && cond < 80) {
			System.out.println("Check engine light has activated.");
		} else if (cond >= 60 && cond < 70) {
			System.out.println("Oil pressure is low.");
		} else if (cond > 0 && cond < 60) {
			System.out.println("Multiple engine warning lights. Engine failure imminent.");
		} else {
			System.out.println("Engine is inoperable.");
		}
	}
	
	public void setRPMs(int rpms) {
		this.rpms = rpms;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getRPMs() {
		return rpms;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	@Override
	public void function() {
		int rpms = getRPMs();
		int speed = getSpeed();
		System.out.println("\nCurrent Engine Status:" + getCond() + "%");
		status();
		System.out.println("RPMs: " + rpms);
		System.out.println("Speed: " + speed);
	}
	
	@Override
	public void describe() {
		System.out.println("Engine: V" + getCylanders() + " " + getFuel());
	}
	
	public void newStart() {
		setCond(100);
		setRPMs(900);
		setSpeed(0);
		System.out.print("Starting engine ");
		for (int i = 0; i < 3; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.print(". ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		try {
			TimeUnit.MILLISECONDS.sleep(250);
			System.out.print("V");
			TimeUnit.MILLISECONDS.sleep(225);
			System.out.print("R");
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.print("O");
			TimeUnit.MILLISECONDS.sleep(175);
			System.out.print("O");
			TimeUnit.MILLISECONDS.sleep(150);
			System.out.print("M");
			TimeUnit.MILLISECONDS.sleep(250);
			System.out.print("\n");
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	
	}
}
