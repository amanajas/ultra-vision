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
    
    public void addRentStatus(int userId, int rentalId, boolean status) throws SQLException {
        if (Database.getInstance().getRentStatus().hasBooking(userId, rentalId)) {
            Database.getInstance().addCustomerRental(
                    (User) Database.getInstance().getUser().getByID(userId), 
                    (Rental) Database.getInstance().getRental().getByID(rentalId),
                    status);
        } else {
            Database.getInstance().addCustomerReturn(
                    (User) Database.getInstance().getUser().getByID(userId), 
                    (Rental) Database.getInstance().getRental().getByID(rentalId),
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
    
}
