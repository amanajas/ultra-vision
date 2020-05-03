package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.ILoyaltyDAO;
import entities.LoyaltyPoints;
import entities.User;
import java.util.List;
import java.util.Map;

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
		List<Map<String, Object>> result = this.db.query("SELECT id, "
				+ "points FROM loyalty "
				+ "WHERE user_id = " + user + ";");
		
                LoyaltyPoints loyalty = null;
                for(Map<String, Object> map : result){
                    loyalty = new LoyaltyPoints(
				(int) map.get("id"), 
				(int) map.get("points")
				);
                }
                return loyalty;
	}

}
