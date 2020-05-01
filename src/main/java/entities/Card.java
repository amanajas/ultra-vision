package entities;

public class Card {
	
	public enum Type {
		Credit, Debit
	}
	
	private int id;
	private Type type;
	private User user;
	
	public Card(int id, Type type, User user) {
		this.id = id;
		this.type = type;
		this.user = user;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Type getType() {
		return type;
	}
	
	public User getUser() {
		return user;
	}
}
