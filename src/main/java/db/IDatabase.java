package db;

import java.util.List;

import entities.Rental;
import entities.User;

public interface IDatabase {
	
	public SQLDatabase get();
	public List<User> getCustomers();
	public List<User> searchCustomer(String name);
	public Boolean addCustomer(User custumer);
	public Boolean editCustomer(User custumer);
	public Boolean deleteCustomer(User custumer);
	public Boolean addTitle(Rental title);
	public List<Rental> searchRental(String title);
	public Boolean editTitle(Rental title);
	public Boolean addCustomerRental(User customer, Rental title);
	public Boolean addCustomerReturn(User customer, Rental title);
}
