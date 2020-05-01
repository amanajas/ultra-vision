package db.dao;

import entities.User;

public interface IUserDAO {
	
	boolean insertUser(User user);
	boolean deleteUser(User user);
	boolean updateUser(User user);
}
