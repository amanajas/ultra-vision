package entities;

import java.util.Date;

public class Rental {
	
	public enum Category {
		ML, VL, TV
	}
	
	private int id;
	private String title;
	private Category category;
	private Date created;
	
	public Rental(int id, String title, Category category) {
		this.id = id;
		this.setTitle(title);
		this.setCategory(category);
		this.created = new Date();
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}


}
