import db.SQLDatabase;

public class Main {

	public static void main(String[] args) {
		
		SQLDatabase db = new SQLDatabase();
		db.create("ultra-vision.db");

	}

}
