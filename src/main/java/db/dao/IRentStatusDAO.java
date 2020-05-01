package db.dao;

import java.sql.ResultSet;

import entities.Rental;
import entities.User;

public interface IRentStatusDAO {
	
	boolean insertRentStatus(User user, Rental rental);
	boolean updateRentStatus(User user,Rental rental);
	ResultSet get(User user);
}
