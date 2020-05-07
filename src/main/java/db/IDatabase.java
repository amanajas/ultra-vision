package db;

import entities.Card;
import java.util.List;

import entities.Rental;
import entities.User;

public interface IDatabase {
	
	public boolean create();
	public List<User> getCustomers();
	public List<User> searchCustomer(String name);
	public Boolean addCustomer(User custumer);
	public Boolean editCustomer(User custumer);
	public Boolean deleteCustomer(User custumer);
	public Boolean addTitle(Rental title);
	public List<Rental> searchRental(String title);
	public Boolean editTitle(Rental title);
	public Boolean addCustomerRental(User customer, Rental title, boolean status);
	public Boolean addCustomerReturn(int rentalId, User customer, Rental title, boolean status);
        public void addCardToUser(User user, Card card);
}
