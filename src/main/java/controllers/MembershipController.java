/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Database;
import entities.Membership;
import entities.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author thiago.amanajas
 */
public class MembershipController implements IController {

    public Membership getMembership(int id) throws SQLException {
        return ((User) Database.getInstance().getUser().getByID(id)).getMembership();
    }
    
    public List<Membership> getAll() throws SQLException {
        return Database.getInstance().getMembership().getAll();
    }
    
    @Override
    public String getEnterValue(String basedValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
