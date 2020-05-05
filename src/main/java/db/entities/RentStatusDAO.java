package db.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IRentStatusDAO;
import entities.Rental;
import entities.User;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RentStatusDAO extends DAO implements IRentStatusDAO {

	public RentStatusDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insertRentStatus(User user, Rental rental) throws SQLException {
            String sql = "INSERT INTO rental_status(id, created, updated, status, user_id, rental_id) VALUES(null, null, null, #1, #2, #3);";
            int id = this.db.insert(sql, true, user.getId(), rental.getId());
            return id;
	}

	@Override
	public boolean updateRentStatus(User user, Rental rental) throws SQLException {
            String sql = "UPDATE rental_status SET updated=#1, status=#2 WHERE user_id=#3 AND rental_id=#4;";
            boolean updated = this.db.update(sql, new Date().getTime(), false, user.getId(), rental.getId());
            return updated;
	}

	@Override
	public List<Map<String, Object>> get(User user) throws SQLException {
            String sql = "SELECT rs.id AS status_id, r.id AS rental_id, r.title AS title, rs.updated "
                    + "FROM rental_status AS rs "
                    + "JOIN rentals AS r ON rs.rental_id=r.id "
                    + "WHERE rs.user_id=#1;";
            return this.db.query(sql, user.getId());
	}

}
