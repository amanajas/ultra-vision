package db.dao;

import java.sql.SQLException;

import entities.LoyaltyPoints;
import entities.User;

public interface ILoyaltyDAO {
	
        int insertLoyalty(User user) throws SQLException;
	boolean updateLoyalty(User user) throws SQLException;
	LoyaltyPoints get(int userId) throws SQLException;
}
