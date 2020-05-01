package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.entities.CardsDAO;
import db.entities.LoyaltyDAO;
import db.entities.MembershipDAO;
import db.entities.RentStatusDAO;
import db.entities.RentalDAO;
import db.entities.UserDAO;
import entities.Rental;
import entities.User;

public class Database implements IDatabase {
	
	private SQLDatabase db;
	private CardsDAO cards;
	private LoyaltyDAO loyalty;
	private RentalDAO rental;
	private RentStatusDAO rentStatus;
	private UserDAO user;
	private MembershipDAO membership;
	
	public Database(SQLDatabase db) {
		this.db = db;
		this.cards = new CardsDAO(db);
		this.loyalty = new LoyaltyDAO(db);
		this.rental = new RentalDAO(db);
		this.rentStatus = new RentStatusDAO(db);
		this.user = new UserDAO(db);
		this.membership = new MembershipDAO(db);
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

	@Override
	public SQLDatabase getDb() {
		return this.db;
	}

	public User executeLogin(String user, String password) throws SQLException {
		ResultSet result = this.db.query("SELECT count(*), u.id, u.name FROM users AS u"
				+ "JOIN access AS a ON a.user_id = u.id"
				+ "WHERE a.password='" + password + "' AND "
						+ "u.name = '" + user + "'");
		
		User userObj = null;
		if (result.getInt(0) > 0) {
			int userId = result.getInt(1);
			userObj = new User(
					userId,
					result.getString(2),
					this.loyalty.get(userId),
					this.membership.get(userId),
					this.cards.get(userId));
		}
		
		return userObj;
	}

}
