package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IMembership;
import entities.Membership;
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
	public Membership get(int user) throws SQLException {
		ResultSet result = this.db.query("SELECT id, "
				+ "description, "
				+ "type.description FROM memberships AS m"
				+ "JOIN membership_type AS type ON type.id = m.type_id"
				+ "WHERE m.user_id = " + user);
		
		Membership.Type type = Membership.Type.valueOf(result.getString(2));
		Membership member = null;
		int id = result.getInt(0);
		String description = result.getString(1);
		if (type.equals(Membership.Type.PR)) {
			member = new Premium(id, description);
		} else if (type.equals(Membership.Type.VL)) {
			member = new Movie(id, description);
		} else if (type.equals(Membership.Type.TV)) {
			member = new Boxset(id, description);
		} else {
			member = new MusicLovers(id, description);
		}
		return member;
	}

}
