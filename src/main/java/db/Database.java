package db;

import java.sql.SQLException;
import java.util.List;

import db.entities.CardsDAO;
import db.entities.LoyaltyDAO;
import db.entities.MembershipDAO;
import db.entities.RentStatusDAO;
import db.entities.RentalDAO;
import db.entities.UserDAO;
import entities.Card;
import entities.Rental;
import entities.User;
import java.util.Map;

public class Database implements IDatabase {
	
	private final SQLDatabase db;
	private final CardsDAO cards;
	private final LoyaltyDAO loyalty;
	private final RentalDAO rental;
	private final RentStatusDAO rentStatus;
	private final UserDAO user;
	private final MembershipDAO membership;
	
	public Database() {
		this.db = new SQLDatabase();
		this.cards = new CardsDAO(db);
		this.loyalty = new LoyaltyDAO(db);
		this.rental = new RentalDAO(db);
		this.rentStatus = new RentStatusDAO(db);
		this.user = new UserDAO(db);
		this.membership = new MembershipDAO(db);
	}
        
        public static Database getInstance() {
            return Database.DatabaseHolder.INSTANCE;
        }
        
        private static class DatabaseHolder {

            private static final Database INSTANCE = new Database();
        }
        
        @Override
        public SQLDatabase get() {
            return this.db;
        }

	public CardsDAO getCards() {
		return cards;
	}

	public LoyaltyDAO getLoyalty() {
		return loyalty;
	}

	public RentalDAO getRental() {
		return rental;
	}

	public RentStatusDAO getRentStatus() {
		return rentStatus;
	}

	public UserDAO getUser() {
		return user;
	}

	@Override
	public List<User> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchCustomer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addCustomer(User custumer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean editCustomer(User custumer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteCustomer(User custumer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addTitle(Rental title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rental> searchRental(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean editTitle(Rental title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addCustomerRental(User customer, Rental title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addCustomerReturn(User customer, Rental title) {
		// TODO Auto-generated method stub
		return null;
	}

	public User executeLogin(String user, String password) throws SQLException {
                
                List<Map<String, Object>> result = this.db.query("SELECT count(*) "
                        + "AS c "
                        + "FROM users AS u "
			+ "JOIN access AS a ON a.user_id = u.id "
			+ "WHERE a.password = '" + password + "' AND "
			+ "u.name = '" + user + "';");
		
		User userObj = null;
                if (result.size() == 1 && (int) result.get(0).get("c") > 0) {
                    userObj = this.user.get(user);
                }
		return userObj;
	}

}
