package db.dao;

import entities.Rental;

public interface IRentalDAO {
	
	boolean insertUser(Rental rental);
	boolean updateUser(Rental rental);
}
