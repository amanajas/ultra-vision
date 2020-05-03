package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IUserDAO;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDAO extends DAO implements IUserDAO {
    
        	private CardsDAO cards;
	private LoyaltyDAO loyalty;
	private MembershipDAO membership;

	public UserDAO(SQLDatabase db) {
            super(db);
            this.cards = new CardsDAO(db);
            this.loyalty = new LoyaltyDAO(db);
            this.membership = new MembershipDAO(db);
	}

	@Override
	public boolean insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
                return false;
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
	public List<User> getAll() throws SQLException {
		List<Map<String, Object>> result = this.db.query("SELECT u.id AS id, u.name AS name, "
                        + "u.member_id AS mid "
                        + "FROM users;");
		
		List<User> list = new ArrayList<>();
                for(Map<String, Object> map : result){
                    list.add(new User(
                                (int) map.get("id"),
                                (String) map.get("name"),
                                this.loyalty.get((int) map.get("id")),
                                this.membership.get((int) map.get("mid")),
                                this.cards.get((int) map.get("id")))
                    );	
                }
		return list;
	}

	@Override
	public User get(String name) throws SQLException {
                List<Map<String, Object>> result = this.db.query("SELECT u.id AS id, u.name AS name, "
                        + "u.member_id AS mid "
                        + "FROM users AS u "
			+ "WHERE u.name = '" + name + "'");
		
		User userObj = null;
                for(Map<String, Object> map : result){
                    userObj = new User(
                                (int) map.get("id"),
                                (String) map.get("name"),
                                this.loyalty.get((int) map.get("id")),
                                this.membership.get((int) map.get("mid")),
                                this.cards.get((int) map.get("id")));	
                }
		return userObj;
	}

}
