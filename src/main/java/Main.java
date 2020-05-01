import db.SQLDatabase;

public class Main {

	public static void main(String[] args) {
		
		
		SQLDatabase db = new SQLDatabase("ultra-vision.db");
		db.create();

	}

}
