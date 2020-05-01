package db.dao;

import java.sql.ResultSet;

import entities.Rental;

public interface IRentalDAO {
	
	boolean insertRental(Rental rental);
	boolean updateRental(Rental rental);
	ResultSet get(String title);
}
