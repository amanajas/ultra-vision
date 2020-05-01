package db.dao;

import java.sql.ResultSet;

import entities.User;

public interface IUserDAO {
	
	boolean insertUser(User user);
	boolean deleteUser(User user);
	boolean updateUser(User user);
	ResultSet get(User user);
	ResultSet getAll();
	ResultSet get(String name);
}
