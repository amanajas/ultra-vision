package entities;

public class Card {

    	public enum Type {
		Credit, Debit
	}
	
	private int id;
	private Type type;
	private int user;
	
        public Card(Type type, int user) {
            this(-1, type, user);
        }
        
	public Card(int id, Type type, int user) {
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
	
	public int getUser() {
		return user;
	}
        
        public void setId(int id) {
            this.id = id;
        }
}
