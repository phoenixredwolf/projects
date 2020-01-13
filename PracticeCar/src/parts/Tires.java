package parts;

public class Tires extends CarParts implements Functional {
	
	private TireType type;
	private String size;

	public Tires(String size, TireType type) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.type = type;
	}
	
	public String getSize() {
		return size;
	}
	
	public TireType getType() {
		return type;
	}
	
	@Override
	public void function() {
		System.out.println("Current status of tires: " + getCond() + "%");
		status();
	}
	
	@Override
	public void status() {
		int cond = getCond();
		if (cond >=80) {
			System.out.println("Tires are in excellent condition");
		} else if (cond >= 65 && cond < 80) {
			System.out.println("Tire pressure low.");
		} else if (cond > 0 && cond <65) {
			System.out.println("Tire tread low.  Replace soon.");
		} else {
			System.out.println("Tire flat.");
		}		
	}

}
