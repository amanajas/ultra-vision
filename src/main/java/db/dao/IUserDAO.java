package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.User;

public interface IUserDAO {
	
	boolean insertUser(User user) throws SQLException;
	boolean deleteUser(User user) throws SQLException;
	boolean updateUser(User user) throws SQLException;
	ResultSet get(User user) throws SQLException;
	ResultSet getAll() throws SQLException;
	ResultSet get(String name) throws SQLException;
}
