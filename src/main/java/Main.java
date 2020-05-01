import db.Database;
import db.SQLDatabase;
import entities.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	/**
	 * Read the user input as string
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String read() throws IOException {
		String word = null;
		try {
			word = new Scanner(System.in).nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return word;
	}
	
	/**
	 * Prints the main menu
	 * @return the user response based on the options
	 * @throws IOException
	 */
	public static String printMainScreen() throws IOException {
		System.out.println("::: Ultra-vision :::");
		System.out.println("");
		System.out.println("A) Search Customer");
		System.out.println("B) Search Rental");
		System.out.println("G) Quit");
		System.out.println("");
        System.out.print("Enter an option: ");
        return read();
	}
	/**
	 * Prints the main menu
	 * @return the user response based on the options
	 * @throws IOException
	 * @throws SQLException 
	 */
	public static User login(SQLDatabase db) throws IOException, SQLException {
		Database dataB = new Database(db);
		User logged = null;
		do {
			System.out.println("::: Login :::");
			System.out.println("");
			System.out.println("user: ");
			String user = read();
			System.out.println("password: ");
			String password = read();
			logged = dataB.executeLogin(user, password);
		} while (logged == null);
        return logged;
	}

	public static void main(String[] args) {
		
		// Creating DB
		SQLDatabase db = new SQLDatabase("ultra-vision.db");
		if (db.create()) {
			try {
				User user = login(db);
				if (user != null) {
					String response = null;
					do {
				        response = printMainScreen();
				        
				        switch(response.toUpperCase()) {
				        case "A":
				        	break;
				        case "B":
				        	break;
				        case "C":
				        	break;
				        case "D":
				        	break;
				        case "E":
				        	break;
				        case "F":
				        	break;
				        }
					} while (response != null && !response.equalsIgnoreCase("G"));
				} else {
					System.err.println("Login failed!");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.err.println("It was not possible to create the database.");
		}

	}

}
