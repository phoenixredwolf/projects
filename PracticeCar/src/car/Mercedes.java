package car;

import java.util.Random;

import parts.Color;
import parts.Engine;
import parts.FuelType;
import parts.TireType;
import parts.Tires;

public class Mercedes extends Car {
	
		Engine engine = new Engine(8, FuelType.Gasoline);
		Tires tires = new Tires("325/30ZR20", TireType.Performance);
		public static Random r = new Random();	

	public Mercedes(int year, String make) {
		super(year, make);
		setIntColor(Color.Black);
		setExtColor(Color.Silver);
		setModel("AMG GT R");
		//Engine engine = this.engine;
		//Tires tires = this.tires;
	}
	
	@Override
	public void describe() {
		
		super.describe();
		System.out.println("Engine: V" + engine.getCylanders() + " " + engine.getFuel());
		System.out.println("Tires: " + tires.getSize() + " " + tires.getType());
	}
	
	public void start() {
		engine.newStart();	
		tires.setCond(100);
	}
	
	public void status() {
		engine.function();
	}
	
	public void accelerate() {
		int currSpeed = engine.getSpeed();
		int newSpeed = r.nextInt(50) +10;
		int damage = r.nextInt(31);
		int hazard;
		
		if (currSpeed == 198) {
			System.out.println("You are already at top speed. No further acceleration possible.");
		} else if (currSpeed < 198 && (currSpeed + newSpeed) < 198) {
			engine.setSpeed(currSpeed + newSpeed);
			engine.setRPMs(engine.getSpeed()*12 + 900);
			System.out.println("Your current speed is now " + engine.getSpeed() + " mph.");
		} else if (currSpeed < 198 && (currSpeed + newSpeed) > 198) {
			engine.setSpeed(198);
			engine.setRPMs(3300);
			System.out.println("Your current speed is now 198 mph.");
		} else {
			engine.setSpeed(currSpeed + newSpeed); 
			engine.setRPMs(engine.getSpeed()*12 + 900);
			System.out.println("Your current speed is now " + engine.getSpeed() + " mph.");
		}
		hazard = checkDamage();
		if (hazard == 1 || hazard == 2) {
			getDamage(tires, damage);
			tires.function();
			if (tires.getCond() == 0) {
				System.out.println("Tires are flat.");
				System.out.println("Thank you for playing");
				System.exit(0);
			}
		}
		if (hazard == 3 || hazard == 4) {
			getDamage(engine, damage);
			engine.function();
			if (engine.getCond() == 0) {
				System.out.println("Engine inoperable.");
				System.out.println("Thank you for playing");
				System.exit(0);
			}
		}
		
	}
	
	public void brake() {
		int newSpeed = r.nextInt(50) +10;
		int currSpeed = engine.getSpeed();
		if ((currSpeed - newSpeed) < 0) {
			engine.setSpeed(0);
			engine.setRPMs(900);
			System.out.println("You have stopped.");
		} else {
			engine.setSpeed(currSpeed - newSpeed);
			engine.setRPMs(engine.getSpeed()*12 + 900);
			System.out.println("You have slowed down.  Your current speed is " + engine.getSpeed());
		}
	}
	
	public <T> void getDamage(T object, int damage) {
		if (object == tires && damage > 0) {
			if ((tires.getCond() - damage) > 0) {
				tires.setCond(tires.getCond() - damage);
			} else {
				tires.setCond(0);
			}
		}
		if (object == engine && damage > 0) {
			if ((engine.getCond() -  damage) > 0) {
				engine.setCond(engine.getCond() - damage);
			} else {
				engine.setCond(0);
			}
		}
	}
	
	public int checkDamage() {
		int hazard = r.nextInt(10);

		switch (hazard) {
		case 0:
			break;
		case 1:
			System.out.println("You ran over a pothole.");
			break;
		case 2:
			System.out.println("You ran over a nail.");
			break;
		case 3:
			System.out.println("You hit a deer!");
			break;
		case 4:
			System.out.println("You have an oil leak.");
		default:
			break;
		}
		return hazard;
	}
	

}
