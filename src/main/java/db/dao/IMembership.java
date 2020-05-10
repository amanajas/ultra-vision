package db.dao;

import java.sql.SQLException;

import entities.Membership;

public interface IMembership {
	
	Membership get(int membership_id) throws SQLException;
}
