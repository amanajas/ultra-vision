package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IUserDAO;
import entities.User;

public class UserDAO extends DAO implements IUserDAO {

	public UserDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return this.db.query("").rowInserted();
	}

	@Override
	public boolean deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet get(User user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet get(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
