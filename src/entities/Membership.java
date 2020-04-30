package entities;

public class Membership {
	
	public enum Type {
		ML, VL, TV, PR
	}
	
	private Type type;
	private String description;
	
	public Membership(String description, Type type) {
		this.description = description;
		this.type = type;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Type getType() {
		return this.type;
	}

}
