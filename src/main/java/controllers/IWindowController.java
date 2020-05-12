/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RentalStatus;
import entities.User;

/**
 *
 * @author thiago.amanajas
 */
public interface IWindowController {
    
    public void showMainWindow();
    public void createMainWindow(User user); 
    public void showLogin();
    public void showRentStatusForm();
    public void showRentStatusForm(RentalStatus rentalStatus);
}
