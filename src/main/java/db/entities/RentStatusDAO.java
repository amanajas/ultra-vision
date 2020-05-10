package db.entities;

import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IRentStatusDAO;
import entities.Rental;
import entities.RentalStatus;
import entities.User;
import utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentStatusDAO extends DAO implements IRentStatusDAO {
    
        private final UserDAO user;
        private final RentalDAO rental;

	public RentStatusDAO(SQLDatabase db) {
		super(db);
                this.user = new UserDAO(db);
                this.rental = new RentalDAO(db);
	}

	@Override
	public int insertRentStatus(int userId, int rentalId, boolean status) throws SQLException {
            String sql = "INSERT INTO rental_status(id, created, updated, status, user_id, rental_id) VALUES(null, null, null, #1, #2, #3);";
            int id = this.db.insert(sql, status ? 1 : 0, userId, rentalId);
            return id;
	}

	@Override
	public boolean updateRentStatus(int rentalStatusId, int userId, int rentalId, boolean status) throws SQLException {
            String sql = "UPDATE rental_status SET updated=#1, status=#2 WHERE user_id=#3 AND rental_id=#4 AND id=#5;";
            boolean updated = this.db.update(sql, NumberUtils.getDate().getTime(), status ? 1 : 0, userId, rentalId, rentalStatusId);
            return updated;
	}
        
        private List<RentalStatus> get(String sql, Object... values) {
            List<Map<String, Object>> result;
            result = this.db.query(sql, values);
            List<RentalStatus> rents = new ArrayList<>();
            if (result != null) {
                result.forEach((map) -> {
                    try {
                    	
                    	/**
                    	 * status_id, 
                    	 * user_id, 
                    	 * rental_id,
                    	 * created, 
                    	 * updated, 
                    	 * status
                    	 */
                    	
                        rents.add(new RentalStatus(
                                    (int) map.get("status_id"),
                                    (User) this.user.getByID((int) map.get("user_id")),
                                    (Rental) this.rental.getByID((int) map.get("rental_id")),
                                    (int) map.get("status") == 1,
                                    NumberUtils.getDate(map.get("created")),
                        			NumberUtils.getDate(map.get("updated")))
                            );
                    } catch (SQLException ex) {
                        Logger.getLogger(RentStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
            return rents;
        }

	@Override
	public List<RentalStatus> get(int userId) throws SQLException {
            String sql = "SELECT rs.id AS status_id, u.id AS user_id, r.id AS rental_id, r.title AS title, "
                    + "rs.created AS created, rs.updated AS updated, rs.status AS status "
                    + "FROM rental_status AS rs "
                    + "JOIN rentals AS r ON rs.rental_id=r.id "
                    + "JOIN users AS u ON u.id=rs.user_id "
                    + "WHERE rs.user_id=#1;";
            return this.get(sql, userId);
	}

    @Override
    public Object getByID(int id) {
    	String sql = "SELECT rs.id AS status_id, u.id AS user_id, r.id AS rental_id, r.title AS title, "
                + "rs.created AS created, rs.updated AS updated, rs.status AS status "
                + "FROM rental_status AS rs "
                + "JOIN rentals AS r ON rs.rental_id=r.id "
                + "JOIN users AS u ON u.id=rs.user_id "
                + "WHERE rs.id=#1;";
    	List<RentalStatus> status = this.get(sql, id);
    	if (status.size() > 0) return status.get(0);
    	return null;
    }

    @Override
    public RentalStatus get(int userId, int rentalId) throws SQLException {
        String sql = "SELECT rs.id AS status_id, u.id AS user_id, r.id AS rental_id, r.title AS title, "
                + "rs.created AS created, rs.updated AS updated, rs.status AS status "
                + "FROM rental_status AS rs "
                + "JOIN rentals AS r ON rs.rental_id=r.id "
                + "JOIN users AS u ON u.id=rs.user_id "
                + "WHERE rs.user_id=#1 AND rs.rental_id=#2;";
        List<RentalStatus> status = this.get(sql, userId, rentalId);
        return status.size() > 0 ? status.get(0) : null;
    }

    @Override
    public boolean hasBooking(int userId, int rentalId) throws SQLException {
        String sql = "SELECT count(*) as count "
                + "FROM rental_status AS rs "
                + "WHERE rs.user_id=#1 AND rs.rental_id=#2;";
        List<Map<String, Object>> status = this.db.query(sql, userId, rentalId);
        return ((int) status.get(0).get("count")) > 0;
    }
    
    @Override
    public boolean hasActiveBooking(int userId, int rentalId) throws SQLException {
        String sql = "SELECT count(*) as count "
                + "FROM rental_status AS rs "
                + "WHERE rs.user_id=#1 AND rs.rental_id=#2 AND status=1;";
        List<Map<String, Object>> status = this.db.query(sql, userId, rentalId);
        return ((int) status.get(0).get("count")) > 0;
    }

    @Override
    public List<RentalStatus> getAll() throws SQLException {
        String sql = "SELECT rs.id AS status_id, u.id AS user_id, r.id AS rental_id, "
                    + "rs.created AS created, rs.updated AS updated, rs.status AS status "
                    + "FROM rental_status AS rs "
                    + "JOIN rentals AS r ON rs.rental_id=r.id "
                    + "JOIN users AS u ON u.id=rs.user_id;";
        return this.get(sql);
    }

}
