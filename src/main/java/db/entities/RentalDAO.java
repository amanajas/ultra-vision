package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IRentalDAO;
import entities.Rental;

public class RentalDAO extends DAO implements IRentalDAO {

	public RentalDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insertRental(Rental rental) throws SQLException {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean updateRental(Rental rental) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet get(String title) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
