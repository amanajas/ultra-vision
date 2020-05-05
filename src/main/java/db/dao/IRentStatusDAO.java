package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Rental;
import entities.User;
import java.util.List;
import java.util.Map;

public interface IRentStatusDAO {
	
	int insertRentStatus(User user, Rental rental) throws SQLException;
	boolean updateRentStatus(User user,Rental rental) throws SQLException;
        List<Map<String, Object>> get(User user) throws SQLException;
}
