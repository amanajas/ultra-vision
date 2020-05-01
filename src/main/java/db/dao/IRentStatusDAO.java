package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Rental;
import entities.User;

public interface IRentStatusDAO {
	
	boolean insertRentStatus(User user, Rental rental) throws SQLException;
	boolean updateRentStatus(User user,Rental rental) throws SQLException;
	ResultSet get(User user) throws SQLException;
}
