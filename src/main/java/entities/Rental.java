package entities;

import java.util.Date;

public class Rental implements IEntity {
	
	private int id;
	private String title;
	private Category category;
	private Date created;
        
    public Rental(String title, Category category) {
        this(-1, title, category);
    }
	
	public Rental(int id, String title, Category category) {
		this(id, title, category, new Date());
	}
        
        public Rental(int id, String title, Category category, Date date) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.created = new Date();
	}
        
        public void setId(int id) {
            this.id = id;
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

	@Override
	public String getDescription() {
		return this.title;
	}


}
