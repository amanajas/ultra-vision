/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Database;
import entities.Card;
import entities.LoyaltyPoints;
import entities.Membership;
import entities.User;
import utils.NumberUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiago.amanajas
 */
public class UserController implements IController {
    
    public User getUser(int id) throws SQLException {
        return (User) Database.getInstance().getUser().getByID(id);
    }
    
    public User getUserByName(String name) throws SQLException {
        List<User> list = Database.getInstance().getUser().get(name);
        return list.size() > 0 ? list.get(0) : null;
    }

	@Override
    public String getEnterValue(String basedValue) throws SQLException {
            if (NumberUtils.isNumeric(basedValue)) {
                    int id = Integer.valueOf(basedValue);
                    User user = this.getUser(id);
                    if (user != null) {
                            return user.getName();
                    }
            }
            return "";
    }

	public boolean addUser(String name, String password, Membership membership) {
		if (name.length() == 0 || password.length() == 0) return false;
		User user = new User(-1, name, new LoyaltyPoints(), membership, new ArrayList<Card>());
		user.setPassword(password);
		return Database.getInstance().addCustomer(user);
	}

	public boolean updateUser(User user, String name, String password, Membership membership) {
		if (name.length() == 0 || password.length() == 0) return false;
		try {
			user.setName(name);
			user.setMembership(membership);
			user.setPassword(password);
			return Database.getInstance().getUser().updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<User> getAll() throws SQLException {
		return Database.getInstance().getUser().getAll();
	}

	public List<User> getUsersByName(String search) throws SQLException {
		return Database.getInstance().searchCustomer(search);
	}
}
