import controllers.WindowController;
import db.Database;
import db.SQLDatabase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import gui.LoginWindow;

public class Main {
	/**
	 * Prints the main menu
         * @param db
	 * @throws IOException
	 * @throws SQLException 
	 */
	public static void login(SQLDatabase db) throws IOException, SQLException {
		final Database dataB = new Database(db);
                WindowController.getInstance().addWindow(new LoginWindow(dataB));
	}

	public static void main(String[] args) {
		
            // Creating DB
            SQLDatabase db = new SQLDatabase("ultra-vision.db");
            if (db.create()) {
                try {
                    login(db);
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.err.println("It was not possible to create the database.");
            }

	}

}
