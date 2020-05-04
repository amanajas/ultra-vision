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
    
        	private final CardsDAO cards;
	private final LoyaltyDAO loyalty;
	private final MembershipDAO membership;

	public UserDAO(SQLDatabase db) {
            super(db);
            this.cards = new CardsDAO(db);
            this.loyalty = new LoyaltyDAO(db);
            this.membership = new MembershipDAO(db);
	}

	@Override
	public int insertUser(User user) throws SQLException {
            String sql = "INSERT INTO users(id, name, member_id) VALUES(null, #1, #2);";
            int id = this.db.insert(sql, user.getName(), user.getMembership().getId());
            user.setId(id);
            this.db.insert(
                    "INSERT INTO access(id, user_id, password) VALUES (null, #1, #2);",
                    id,
                    user.getPassword());
            return id;
	}

	@Override
	public boolean deleteUser(User user) throws SQLException {
            String sql1 = "DELETE FROM loyalty WERE user_id=#1;";
            String sql2 = "DELETE FROM access WERE user_id=#1;";
            String sql3 = "DELETE FROM users WERE id=#1;";
            return (
                    this.db.update(sql1, user.getId()) &&
                    this.db.update(sql2, user.getId()) &&
                    this.db.update(sql3, user.getId())
                  );
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
            boolean result;
            result = this.db.update(
                    "UPDATE users SET name='#1', member_id=#2 WHERE id=#3;",
                    user.getName(), user.getMembership().getId(), user.getId());
            if (result) {
                result = this.loyalty.updateLoyalty(user);
                if (!result) {
                    System.out.println("Loyalty could not be updated.");
                }
            } else {
                System.out.println("User could not be updated.");
            }
            return result;
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
