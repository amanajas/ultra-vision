package db.dao;

import java.sql.SQLException;

import entities.Membership;

public interface IMembership {
	
	boolean updateMembership(int user, Membership membership) throws SQLException;
	Membership get(int user) throws SQLException;
}
