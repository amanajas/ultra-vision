package db.dao;

import java.sql.SQLException;

import entities.LoyaltyPoints;
import entities.User;

public interface ILoyaltyDAO {
	
	boolean updateLoyalty(User user) throws SQLException;
	LoyaltyPoints get(int user) throws SQLException;
}
