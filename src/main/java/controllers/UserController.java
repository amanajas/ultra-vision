/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Database;
import entities.User;
import utils.NumberUtils;

import java.sql.SQLException;
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
}
