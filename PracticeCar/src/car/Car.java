package car;

import parts.Color;

public class Car {
	
	private Color extColor;
	private Color intColor;
	private String make;
	private String model;
	private int year;
	
	public Car(int year, String make) {
		this.year = year;
		this.make = make;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Color getExtColor(){
		return extColor;
	}
	
	public void setExtColor(Color extColor) {
		this.extColor = extColor;
	}
	
	public Color getIntColor() {
		return intColor;
	}
	
	public void setIntColor(Color intColor) {
		this.intColor = intColor;
	}
	
	public void run() {
		System.out.println("We're on our way down the road.");
	}
	
	public void describe() {
		System.out.println("Year: " + getYear());
		System.out.println("Make: " + getMake());
		System.out.println("Model: " + getModel());
		System.out.println("Exterior Color: " + getExtColor());
		System.out.println("Interior Color: " + getIntColor());
	}
}
