package db.dao;

import java.sql.SQLException;

import entities.RentalStatus;
import java.util.List;

public interface IRentStatusDAO {
	
	int insertRentStatus(int userId, int rentalId, boolean status) throws SQLException;
	boolean updateRentStatus(int rentalStatusId, int userId, int rentalId, boolean status) throws SQLException;
        List<RentalStatus> get(int userId) throws SQLException;
        RentalStatus get(int userId, int rentalId) throws SQLException;
        boolean hasBooking(int userId, int rentalId) throws SQLException;
        List<RentalStatus> getAll() throws SQLException;
        boolean hasActiveBooking(int userId, int rentalId) throws SQLException;
}
