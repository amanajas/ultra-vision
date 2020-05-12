package entities;

public class LoyaltyPoints implements IEntity{
	
	private int id;
	private Integer points;
	
	public LoyaltyPoints() {
		this(-1, 0);
	}
	
	public LoyaltyPoints(int id, int amount) {
		this.id = -1;
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

    public void setId(int id) {
        this.id = id;
    }

	@Override
	public String getDescription() {
		return this.id + "-" + this.points;
	}

}
