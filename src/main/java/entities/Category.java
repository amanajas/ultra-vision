package entities;

public class Category implements IEntity {
	
	private int id;
	private String description;
	
	public Category(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
