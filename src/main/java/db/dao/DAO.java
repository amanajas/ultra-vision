package db.dao;

import db.SQLDatabase;
import java.sql.SQLException;

public abstract class DAO {

	protected SQLDatabase db;
	
	public DAO(SQLDatabase db) {
		this.db = db;
	}
        
        public abstract Object getByID(int id) throws SQLException ;
}
