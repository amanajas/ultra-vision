package db.entities;

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
            String sql = "UPDATE loyalty SET points=#1 WHERE id=#2;";
            return this.db.update(sql, user.getLoyalty().getPoints(), user.getId());
	}

	@Override
	public LoyaltyPoints get(int userId) throws SQLException {
		List<Map<String, Object>> result = this.db.query("SELECT id, "
				+ "points FROM loyalty "
				+ "WHERE user_id = " + userId + ";");
		
                LoyaltyPoints loyalty = null;
                for(Map<String, Object> map : result){
                    loyalty = new LoyaltyPoints(
				(int) map.get("id"), 
				(int) map.get("points")
				);
                }
                return loyalty;
	}

    @Override
    public int insertLoyalty(User user) throws SQLException {
        String sql = "INSERT INTO loyalty (id, points, user_id) VALUES (null, #1, #2);";
        int id = this.db.insert(sql, user.getLoyalty().getPoints(), user.getId());
        user.getLoyalty().setId(id);
        return id;
    }

    @Override
    public Object getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
