package db.dao;

import java.sql.SQLException;

import entities.Rental;
import entities.RentalStatus;
import entities.User;
import java.util.List;

public interface IRentStatusDAO {
	
	int insertRentStatus(User user, Rental rental) throws SQLException;
	boolean updateRentStatus(User user,Rental rental) throws SQLException;
        List<RentalStatus> get(User user) throws SQLException;
        RentalStatus get(User user, Rental rental) throws SQLException;
}
