package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IRentStatusDAO;
import entities.Rental;
import entities.User;

public class RentStatusDAO extends DAO implements IRentStatusDAO {

	public RentStatusDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insertRentStatus(User user, Rental rental) throws SQLException {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean updateRentStatus(User user, Rental rental) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet get(User user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
