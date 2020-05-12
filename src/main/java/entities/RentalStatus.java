/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author thiago.amanajas
 */
public class RentalStatus implements IEntity {
    
    private int id;
    private User user;
    private Rental rental;
    private boolean status;
    private Date created;
    private Date updated;
    
    public RentalStatus(User user, Rental rental) {
        this(-1, user, rental, true, null, null);
    }
    
    public RentalStatus(int id, User user, Rental rental, boolean status, Date created, Date updated) {
        this.id = id;
        this.user = user;
        this.rental = rental;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean getStatus() {
        return this.status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

	@Override
	public String getDescription() {
		return this.getStatus() + "-" + this.rental.getTitle();
	}    
}
