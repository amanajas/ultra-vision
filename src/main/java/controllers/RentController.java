/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Database;
import entities.Rental;
import entities.RentalStatus;
import entities.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thiago.amanajas
 */
public class RentController {
    
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
        List<Rental> list = Database.getInstance().getRental().get(title);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<RentalStatus> getAllRents() throws SQLException {
        return Database.getInstance().getRentStatus().getAll();
    }

    public boolean hasActive(int userId, int rentalId) throws SQLException {
        return Database.getInstance().getRentStatus().hasActiveBooking(userId, 
                rentalId);
    }
    
}
