package db.entities;

import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IMembership;
import entities.Membership;
import java.util.ArrayList;
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
        
        private List<Membership> getType(List<Map<String, Object>> list) {
            List<Membership> memberships = new ArrayList<>();
            for(Map<String, Object> map : list){
                Membership.Type type = Membership.Type.valueOf(
                        (String) map.get("type"));
                int id = (int) map.get("id");
                String description = (String) map.get("description");
                switch (type) {
                    case PR:
                        memberships.add(new Premium(id, description));
                        break;
                    case VL:
                        memberships.add(new Movie(id, description));
                        break;
                    case TV:
                        memberships.add(new Boxset(id, description));
                        break;
                    default:
                        memberships.add(new MusicLovers(id, description));
                        break;
                }
            }
            return memberships;
        }

	@Override
	public Membership get(int membership_id) throws SQLException {
                List<Map<String, Object>> result = this.db.query("SELECT m.id AS id, "
                      + "m.description AS description, "
                      + "t.description AS type "
                      + "FROM memberships AS m "
                      + "JOIN membership_type AS t ON t.id = m.type_id "
                      + "WHERE m.id = " + membership_id + ";");
		List<Membership> list = this.getType(result);
                return list.size() > 0 ? list.get(0) : null;
	}

    @Override
    public Object getByID(int id) throws SQLException {
        return this.get(id);
    }

    @Override
    public List<Membership> getAll() {
        List<Map<String, Object>> result = this.db.query("SELECT m.id AS id, "
                      + "m.description AS description, "
                      + "t.description AS type "
                      + "FROM memberships AS m "
                      + "JOIN membership_type AS t ON t.id = m.type_id;");
        return this.getType(result);
    }

	public Membership getByDescription(String description) throws SQLException {
		List<Map<String, Object>> result = this.db.query("SELECT m.id AS id, "
                + "m.description AS description, "
                + "t.description AS type "
                + "FROM memberships AS m "
                + "JOIN membership_type AS t ON t.id = m.type_id "
                + "WHERE m.description='#1';", description);
		List<Membership> list = this.getType(result);
        return list.size() > 0 ? list.get(0) : null;
	}

}
