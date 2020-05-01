package db.dao;

import java.sql.ResultSet;

import entities.User;

public interface ILoyaltyDAO {
	
	boolean updateLoyalty(User user);
	ResultSet get(User user);
}
