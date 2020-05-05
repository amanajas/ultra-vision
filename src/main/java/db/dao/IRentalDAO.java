package db.dao;

import java.sql.SQLException;

import entities.Rental;
import java.util.List;

public interface IRentalDAO {
	
	int insertRental(Rental rental) throws SQLException;
	boolean updateRental(Rental rental) throws SQLException;
	List<Rental> get(String title) throws SQLException;
}
