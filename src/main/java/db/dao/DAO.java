package db.dao;

import db.SQLDatabase;

public class DAO {

	protected SQLDatabase db;
	
	public DAO(SQLDatabase db) {
		this.db = db;
	}
}
