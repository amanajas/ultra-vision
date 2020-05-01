package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.ILoyaltyDAO;
import entities.LoyaltyPoints;
import entities.User;

public class LoyaltyDAO extends DAO implements ILoyaltyDAO {

	public LoyaltyDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateLoyalty(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoyaltyPoints get(int user) throws SQLException {
		ResultSet result = this.db.query("SELECT id, "
				+ "points"
				+ "WHERE m.user_id = " + user);
		
		return new LoyaltyPoints(
				result.getInt(0), 
				result.getInt(1)
				);
	}

}
