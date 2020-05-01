package db;

import java.util.List;

import entities.Rental;
import entities.User;

public class Database implements IDatabase {
	
	private SQLDatabase db;
	
	public Database(SQLDatabase db) {
		this.db = db;
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
