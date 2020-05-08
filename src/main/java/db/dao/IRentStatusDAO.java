package db.dao;

import java.sql.SQLException;

import entities.Rental;
import entities.RentalStatus;
import entities.User;
import java.util.List;

public interface IRentStatusDAO {
	
	int insertRentStatus(int userId, int rentalId, boolean status) throws SQLException;
	boolean updateRentStatus(int rentalStatusId, int userId, int rentalId, boolean status) throws SQLException;
        List<RentalStatus> get(User user) throws SQLException;
        RentalStatus get(User user, Rental rental) throws SQLException;
        boolean hasBooking(int userId, int rentalId) throws SQLException;
        List<RentalStatus> getAll() throws SQLException;
        boolean hasActiveBooking(int userId, int rentalId) throws SQLException;
}
