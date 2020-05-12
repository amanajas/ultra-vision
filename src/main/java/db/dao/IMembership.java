package db.dao;

import java.sql.SQLException;

import entities.Membership;
import java.util.List;

public interface IMembership {
	
	Membership get(int membership_id) throws SQLException;
        List<Membership> getAll();
}
