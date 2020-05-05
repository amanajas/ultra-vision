import controllers.WindowController;
import db.Database;


public class Main {

	public static void login() {
                WindowController.getInstance().showLogin();
	}

	public static void main(String[] args) {
		
            // Creating DB
            if (Database.getInstance().create()) {
                login();
            } else {
                System.err.println("It was not possible to create the database.");
            }

	}

}
