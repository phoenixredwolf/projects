package parts;


public abstract class CarParts implements Functional{
	
	private int condition;

	
	public void status() {}
	
	public void function() {}
	
	public void describe() {}
	
	public void setCond(int condition) {
		this.condition = condition;
	}
	
	public int getCond() {
		return condition;
	}

}

