package db.entities;

import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IRentStatusDAO;
import entities.Rental;
import entities.RentalStatus;
import entities.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentStatusDAO extends DAO implements IRentStatusDAO {
    
        private UserDAO user;
        private RentalDAO rental;

	public RentStatusDAO(SQLDatabase db) {
		super(db);
                this.user = new UserDAO(db);
                this.rental = new RentalDAO(db);
	}

	@Override
	public int insertRentStatus(User user, Rental rental, boolean status) throws SQLException {
            String sql = "INSERT INTO rental_status(id, created, updated, status, user_id, rental_id) VALUES(null, null, null, #1, #2, #3);";
            int id = this.db.insert(sql, status, user.getId(), rental.getId());
            return id;
	}

	@Override
	public boolean updateRentStatus(User user, Rental rental, boolean status) throws SQLException {
            String sql = "UPDATE rental_status SET updated=#1, status=#2 WHERE user_id=#3 AND rental_id=#4;";
            boolean updated = this.db.update(sql, new Date().getTime(), status, user.getId(), rental.getId());
            return updated;
	}
        
        private List<RentalStatus> get(String sql, User user, Rental rental) {
            List<Map<String, Object>> result;
            if (rental != null) {
                result =  this.db.query(sql, user.getId(), rental.getId());
            } else {
                result =  this.db.query(sql, user.getId());
            }
            List<RentalStatus> rents = new ArrayList<>();
            result.forEach((map) -> {
                try {
                    rents.add(new RentalStatus(
                                (int) map.get("status_id"),
                                (User) this.user.getByID((int) map.get("user_id")),
                                (Rental) this.rental.getByID((int) map.get("rental_id")),
                                (boolean) map.get("status"),
                                new Date((long) map.get("created")),
                                new Date((long) map.get("updated"))
                        )
                    );
                } catch (SQLException ex) {
                    Logger.getLogger(RentStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            return rents;
        }

	@Override
	public List<RentalStatus> get(User user) throws SQLException {
            String sql = "SELECT rs.id AS status_id, u.id AS user_id, r.id AS rental_id, r.title AS title, "
                    + "rs.created AS created, rs.updated AS updated "
                    + "FROM rental_status AS rs "
                    + "JOIN rentals AS r ON rs.rental_id=r.id "
                    + "JOIN users AS u ON u.id=rs.user_id "
                    + "WHERE rs.user_id=#1;";
            return this.get(sql, user, null);
	}

    @Override
    public Object getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RentalStatus get(User user, Rental rental) throws SQLException {
        String sql = "SELECT rs.id AS status_id, u.id AS user_id, r.id AS rental_id, r.title AS title, "
                + "rs.created AS created, rs.updated AS updated "
                + "FROM rental_status AS rs "
                + "JOIN rentals AS r ON rs.rental_id=r.id "
                + "JOIN users AS u ON u.id=rs.user_id "
                + "WHERE rs.user_id=#1 AND rs.rental_id=#2;";
        List<RentalStatus> status = this.get(sql, user, rental);
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

}
