package entities;

public class Card {
	
	public enum Type {
		Credit, Debit
	}
	
	private int id;
	private Type type;
	
	public Card(int id, Type type) {
		this.id = id;
		this.type = type;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Type getType() {
		return type;
	}
}
