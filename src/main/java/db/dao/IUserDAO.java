package db.dao;

import java.sql.SQLException;

import entities.User;
import java.util.List;

public interface IUserDAO {
	
	int insertUser(User user) throws SQLException;
	boolean deleteUser(User user) throws SQLException;
	boolean updateUser(User user) throws SQLException;
	List<User> getAll() throws SQLException;
	List<User> get(String name) throws SQLException;
}
