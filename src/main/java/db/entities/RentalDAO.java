package db.entities;

import java.sql.SQLException;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.IRentalDAO;
import entities.Category;
import entities.Rental;
import utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RentalDAO extends DAO implements IRentalDAO {

	public RentalDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}
        
    private List<Rental> get(String sql, Object... values) {
        List<Map<String, Object>> result;
        result = this.db.query(sql, values);
        List<Rental> rentals = new ArrayList<>();
        result.forEach((map) -> {
            rentals.add(new Rental(
                    (int) map.get("id"),
                    (String) map.get("title"),
                    new Category((int) map.get("category_id"),
                    		String.valueOf(map.get("description"))),
                    NumberUtils.getDate(map.get("created")))
            );
        });
        return rentals;
    }

	@Override
	public int insertRental(Rental rental) throws SQLException {
            String sql = "INSERT INTO rentals(id, title, created, category_id) VALUES(null, #1, #2, #3);";
            int id = this.db.insert(sql, rental.getTitle(), rental.getCreated().getTime(), 
            		rental.getCategory().getId());
            rental.setId(id);
            return id;
	}

	@Override
	public boolean updateRental(Rental rental) throws SQLException {
		String sql = "UPDATE rentals SET title='#1', category_id=#2 WHERE id=#3;";
        return this.db.update(sql, rental.getTitle(), rental.getCategory().getId());
	}

	@Override
	public List<Rental> getLikeTitle(String title) throws SQLException {
            String sql = "SELECT r.id AS id, rc.description AS description, "
                        + "r.created AS created, r.title AS title, "
                        + "rc.id AS category_id "
                        + "FROM rentals AS r "
                        + "JOIN rental_category AS rc ON rc.id=r.category_id "
			+ "WHERE r.title LIKE '#1%';";

            return this.get(sql, title);
	}
        
        @Override
	public List<Rental> getExactTitle(String title) throws SQLException {
            String sql = "SELECT r.id AS id, rc.description AS description, "
                        + "r.created AS created, r.title AS title, "
                        + "rc.id AS category_id "
                        + "FROM rentals AS r "
                        + "JOIN rental_category AS rc ON rc.id=r.category_id "
			+ "WHERE r.title='#1';";

            return this.get(sql, title);
	}

        @Override
        public List<Rental> getAll() throws SQLException {
            String sql = "SELECT r.id AS id, rc.description AS description, "
                        + "r.created AS created, r.title AS title, "
                        + "rc.id AS category_id "
                        + "FROM rentals AS r "
                        + "JOIN rental_category AS rc ON rc.id=r.category_id;";

            return this.get(sql);
        }

        @Override
        public Object getByID(int id)  throws SQLException {
            String sql = "SELECT r.id AS id, rc.description AS description, "
                        + "r.created AS created, r.title AS title, "
                        + "rc.id AS category_id "
                        + "FROM rentals AS r "
                        + "JOIN rental_category AS rc ON rc.id=r.category_id "
                    + "WHERE r.id=#1;";

            return this.get(sql, id).get(0);
        }
        
        private List<Category> getCategoryList(String sql, Object... values) {
        	List<Map<String, Object>> result;
	        result = this.db.query("SELECT id AS category_id, description "
	        		+ "FROM rental_category;", values);
	        List<Category> categories = new ArrayList<>();
	        result.forEach((map) -> {
	        	categories.add(new Category((int) map.get("category_id"),
                		String.valueOf(map.get("description"))));
	        });
	        return categories;
        }

		public List<Category> getCategories() {
			String sql = "SELECT id AS category_id, description "
	        		+ "FROM rental_category";
			return this.getCategoryList(sql);
		}

		public Category getCategory(String description) {
			String sql = "SELECT id AS category_id, description "
					+ "FROM rental_category "
					+ "WHERE description='#1';";
			List<Category> list = this.getCategoryList(sql, description);
			return list.size() > 0 ? list.get(0) : null;
		}

}
