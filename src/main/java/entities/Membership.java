package entities;

public abstract class Membership {
	
	public enum Type {
		ML, VL, TV, PR
	}
	
	private int id;
	private Type type;
	private String description;
	
	public Membership(int id, String description, Type type) {
		this.id = id;
		this.description = description;
		this.type = type;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public int getId() {
		return this.id;
	}
	
	public abstract AccessRule getRules();

}
