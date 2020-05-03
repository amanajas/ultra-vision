package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IMembership;
import entities.Membership;
import java.util.List;
import java.util.Map;
import memberships.Boxset;
import memberships.Movie;
import memberships.MusicLovers;
import memberships.Premium;

public class MembershipDAO extends DAO implements IMembership {

	public MembershipDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateMembership(int user, Membership membership) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Membership get(int membership_id) throws SQLException {
                List<Map<String, Object>> result = this.db.query("SELECT m.id AS id, "
                      + "m.description AS description, "
                      + "t.description AS type "
                      + "FROM memberships AS m "
                      + "JOIN membership_type AS t ON t.id = m.type_id "
                      + "WHERE m.id = " + membership_id + ";");
		
                Membership member = null;
                for(Map<String, Object> map : result){
                    Membership.Type type = Membership.Type.valueOf(
                            (String) map.get("type"));
                    int id = (int) map.get("id");
                    String description = (String) map.get("description");
                    switch (type) {
                        case PR:
                            member = new Premium(id, description);
                            break;
                        case VL:
                            member = new Movie(id, description);
                            break;
                        case TV:
                            member = new Boxset(id, description);
                            break;
                        default:
                            member = new MusicLovers(id, description);
                            break;
                    }
                }
		return member;
	}

}
