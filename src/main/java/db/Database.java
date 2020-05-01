package db;

import java.util.List;

import db.entities.CardsDAO;
import db.entities.LoyaltyDAO;
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
	
	public Database(SQLDatabase db) {
		this.db = db;
		this.cards = new CardsDAO();
		this.loyalty = new LoyaltyDAO();
		this.rental = new RentalDAO();
		this.rentStatus = new RentStatusDAO();
		this.user = new UserDAO();
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

}
