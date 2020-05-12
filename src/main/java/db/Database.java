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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public boolean create() {
        return this.db.create();
    }

    @Override
    public void addCardToUser(User user, Card card) {
            try {
                this.cards.insertCard(card);
                user.getLoyalty().addPoints(Card.POINTS);
                this.loyalty.updateLoyalty(user);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
        private static class DatabaseHolder {

            private static final Database INSTANCE = new Database();
        }
        
        public MembershipDAO getMembership() {
            return membership;
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
            try {
                // TODO Auto-generated method stub
                return this.user.getAll();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
	}

	@Override
	public List<User> searchCustomer(String name) {
            try {
                // TODO Auto-generated method stub
                return this.user.get(name);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
	}

	@Override
	public Boolean addCustomer(User custumer) {
            try {
                // TODO Auto-generated method stub
                return this.user.insertUser(custumer) > 0;
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	@Override
	public Boolean editCustomer(User custumer) {
            try {
                // TODO Auto-generated method stub
                return this.user.updateUser(custumer);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	@Override
	public Boolean deleteCustomer(User user) {
            try {
                // TODO Auto-generated method stub
                return this.user.deleteUser(user.getId());
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	@Override
	public Boolean addTitle(Rental title) {
            try {
                // TODO Auto-generated method stub
                return this.rental.insertRental(title) > 0;
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	@Override
	public List<Rental> searchRental(String title) {
            try {
                return this.rental.getLikeTitle(title);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
	}

	@Override
	public Boolean editTitle(Rental title) {
            try {
                // TODO Auto-generated method stub
                return this.rental.updateRental(title);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	@Override
	public Boolean addCustomerRental(int userId, int rentalId, boolean status) {
            try {
                return this.rentStatus.insertRentStatus(userId, rentalId, status) > 0;
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	@Override
	public Boolean addCustomerReturn(int rentalStatusId, int userId, int rentalId, boolean status) {
            try {
                return this.rentStatus.updateRentStatus(rentalStatusId, userId, rentalId, status);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
	}

	public User executeLogin(String user, String password) throws SQLException {
                
                List<Map<String, Object>> result = this.db.query("SELECT count(*) "
                        + "AS c "
                        + "FROM users AS u "
			+ "JOIN access AS a ON a.user_id = u.id "
			+ "WHERE a.password = '" + password + "' AND "
			+ "u.name = '" + user + "';");
		
                if (result.size() == 1 && (int) result.get(0).get("c") > 0) {
                    return this.user.get(user).get(0);
                }
		return null;
	}

}
