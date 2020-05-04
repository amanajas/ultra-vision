package db.dao;

import java.sql.SQLException;

import entities.Membership;

public interface IMembership {
	
	Membership get(int user) throws SQLException;
}
