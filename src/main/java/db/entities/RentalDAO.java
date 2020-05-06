package db.entities;

import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IRentalDAO;
import entities.Rental;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RentalDAO extends DAO implements IRentalDAO {

	public RentalDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insertRental(Rental rental) throws SQLException {
            List<Map<String, Object>> result = this.db.query("SELECT id "
                      + "FROM rental_category AS rc "
                      + "WHERE description = '" + rental.getCategory() + "';");
            int id = -1;
            for(Map<String, Object> map : result){
                String sql = "INSERT INTO rentals(id, title, created, category_id) VALUES(null, #1, #2, #3);";
                id = this.db.insert(sql, rental.getTitle(), rental.getCreated().getTime(), map.get("id"));
                rental.setId(id);
            }
            return id;
	}

	@Override
	public boolean updateRental(Rental rental) throws SQLException {
            List<Map<String, Object>> result = this.db.query("SELECT id "
                      + "FROM rental_category AS rc "
                      + "WHERE description = '" + rental.getCategory() + "';");
            boolean updated = false;
            for(Map<String, Object> map : result){
                String sql = "UPDATE rentals SET title='#1', category_id=#2 WHERE id=#3;";
                updated = this.db.update(sql, rental.getTitle(), map.get("id"));
            }
            return updated;
	}

	@Override
	public List<Rental> get(String title) throws SQLException {
            List<Map<String, Object>> result = this.db.query("SELECT r.id AS id, rc.description AS description, "
                        + "r.created AS created, r.title AS title "
                        + "FROM rentals AS r "
                        + "JOIN rental_category AS rc ON rc.id=r.category_id "
			+ "WHERE r.title LIKE '%" + title + "'%;");

            List<Rental> rentals = new ArrayList<>();
            result.forEach((map) -> {
                rentals.add(new Rental(
                        (int) map.get("id"),
                        (String) map.get("title"),
                        Rental.Category.valueOf(String.valueOf(map.get("description"))),
                        new Date((long) map.get("create")))
                );
            });
            return rentals;
	}

        @Override
        public List<Rental> getAll() throws SQLException {
            List<Map<String, Object>> result = this.db.query("SELECT r.id AS id, rc.description AS description, "
                        + "r.created AS created, r.title AS title "
                        + "FROM rentals AS r "
                        + "JOIN rental_category AS rc ON rc.id=r.category_id;");

            List<Rental> rentals = new ArrayList<>();
            result.forEach((map) -> {
                rentals.add(new Rental(
                        (int) map.get("id"),
                        (String) map.get("title"),
                        Rental.Category.valueOf(String.valueOf(map.get("description"))),
                        new Date((long) map.get("create")))
                );
            });
            return rentals;
        }

        @Override
        public Object getByID(int id)  throws SQLException {
            List<Map<String, Object>> result = this.db.query("SELECT r.id AS id, rc.description AS description, "
                        + "r.created AS created, r.title AS title "
                        + "FROM rentals AS r "
                        + "JOIN rental_category AS rc ON rc.id=r.category_id "
                    + "WHERE r.id=#1;", id);

            List<Rental> rentals = new ArrayList<>();
            result.forEach((map) -> {
                rentals.add(new Rental(
                        (int) map.get("id"),
                        (String) map.get("title"),
                        Rental.Category.valueOf(String.valueOf(map.get("description"))),
                        new Date((long) map.get("create")))
                );
            });
            return rentals.size() > 0 ? rentals.get(0) : null;
        }

}
