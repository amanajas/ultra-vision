package db.dao;

import java.sql.SQLException;

import entities.Rental;
import java.util.List;

public interface IRentalDAO {
	
	int insertRental(Rental rental) throws SQLException;
	boolean updateRental(Rental rental) throws SQLException;
	List<Rental> getLikeTitle(String title) throws SQLException;
	List<Rental> getExactTitle(String title) throws SQLException;
        List<Rental> getAll() throws SQLException;
}
