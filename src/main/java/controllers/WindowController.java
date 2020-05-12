/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RentalStatus;
import entities.User;
import gui.LoginWindow;
import gui.MainWindow;
import gui.RentStatusForm;
import gui.RentalForm;
import gui.UserForm;
import gui.Window;
import java.util.HashMap;

/**
 *
 * @author thiago.amanajas
 */
public class WindowController implements IWindowController {
    
    private final HashMap<String, Window> windows;
    
    private WindowController() {
        this.windows = new HashMap<>();
    }
    
    public static WindowController getInstance() {
        return WindowControllerHolder.INSTANCE;
    }

    @Override
    public void showLogin() {
        if (this.windows.get(LoginWindow.NAME) == null) {
            this.addWindow(new LoginWindow());
        }
        this.showWindow(LoginWindow.NAME, true);
    }
    
    @Override
    public void showMainWindow() {
        this.showWindow(MainWindow.NAME, true);
    }

    @Override
    public void createMainWindow(User user) {
        if (this.windows.get(MainWindow.NAME) == null) {
            this.addWindow(new MainWindow(user));
        }
    }

    @Override
    public void showRentStatusForm() {
        RentStatusForm rentStatusForm = (RentStatusForm) this.windows.get(RentStatusForm.NAME);
        if (rentStatusForm == null) {
            rentStatusForm = new RentStatusForm();
            this.addWindow(rentStatusForm);
        }
        rentStatusForm.clear();
        this.showWindow(RentStatusForm.NAME, true);
    }

    @Override
    public void showRentStatusForm(RentalStatus rentalStatus) {
        RentStatusForm rentStatusForm = (RentStatusForm) this.windows.get(RentStatusForm.NAME);
        if (rentStatusForm == null) {
            rentStatusForm = new RentStatusForm();
            this.addWindow(rentStatusForm);
        }
        rentStatusForm.setSelectedRentStatus(rentalStatus);
        this.showWindow(RentStatusForm.NAME, true);
    }

    private static class WindowControllerHolder {
        private static final WindowController INSTANCE = new WindowController();
    }
    
    private void addWindow(Window window) {
        this.windows.put(window.getName(), window);
        this.showWindow(window.getName(), true);
    }
    
    private void showWindow(String key, boolean flag) {
        this.windows.entrySet().forEach((window) -> {
            if (window.getKey().equals(key)) {
                window.getValue().setVisible(flag);
            } else {
                window.getValue().setVisible(false);
            }
        });
    }

	public void showUserForm() {
		UserForm userForm = (UserForm) this.windows.get(UserForm.NAME);
        if (userForm == null) {
            userForm = new UserForm();
            this.addWindow(userForm);
        }
        userForm.clear();
        this.showWindow(UserForm.NAME, true);
		
	}

	public void showRentalForm() {
		RentalForm rentalForm = (RentalForm) this.windows.get(RentalForm.NAME);
        if (rentalForm == null) {
        	rentalForm = new RentalForm();
            this.addWindow(rentalForm);
        }
        rentalForm.clear();
        this.showWindow(RentalForm.NAME, true);
		
	}

	public void showRentalSearchForm() {
		// TODO Auto-generated method stub
		
	}

	public void showUserSearchForm() {
		// TODO Auto-generated method stub
		
	}
}
