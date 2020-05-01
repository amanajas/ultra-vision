package entities;

public class LoyaltyPoints {
	
	private int id;
	private Integer points;
	
	public LoyaltyPoints(int id) {
		this(id, 0);
	}
	
	public LoyaltyPoints(int id, int amount) {
		this.id = id;
		this.points = amount;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setPoints(int amount) {
		this.points = amount;
	}
	
	public void addPoints(int amount) {
		this.points += amount;
	}
	
	public int getPoints() {
		return this.points;
	}

}
