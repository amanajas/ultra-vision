package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Rental;

public interface IRentalDAO {
	
	boolean insertRental(Rental rental) throws SQLException;
	boolean updateRental(Rental rental) throws SQLException;
	ResultSet get(String title) throws SQLException;
}
