/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Database;
import entities.Rental;
import entities.RentalStatus;
import utils.NumberUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiago.amanajas
 */
public class RentController implements IController{
    
    public boolean addRentStatus(RentalStatus rentalStatus, int userId, int rentalId, boolean status) throws SQLException {
        Database database = Database.getInstance();
        if (rentalStatus == null) {
            return database.addCustomerRental(
                    userId, 
                    rentalId,
                    status);
        } else {
            return database.addCustomerReturn(rentalStatus.getId(),
                    userId, 
                    rentalId,
                    status);
        }
    }
    
    public Rental getRentByTitle(String title) throws SQLException {
        List<Rental> list = Database.getInstance().getRental().getExactTitle(title);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    public List<RentalStatus> getRentStatusByDescription(String description) throws SQLException {
    	List<Rental> rents = Database.getInstance().getRental().getLikeTitle(description);
    	List<RentalStatus> list;
    	if (description.length() > 0 && rents.size() > 0) {
    		list = new ArrayList<RentalStatus>();
    		rents.forEach((map) -> {
    			list.add((RentalStatus) Database.getInstance().getRentStatus().getByID(map.getId()));
            });
    	} else {
    		list = Database.getInstance().getRentStatus().getAll();
    	}
    	return list;
    }
    
    public List<RentalStatus> getAllRents() throws SQLException {
        return Database.getInstance().getRentStatus().getAll();
    }

    public boolean hasActive(int userId, int rentalId) throws SQLException {
        return Database.getInstance().getRentStatus().hasActiveBooking(userId, 
                rentalId);
    }

	@Override
	public String getEnterValue(String basedValue) throws SQLException {
		if (basedValue.length() > 0) {
			Rental rental = this.getRentByTitle(basedValue);
			if (rental != null) {
				return String.valueOf(rental.getId());
			}
		}
		return "";
	}
    
}
