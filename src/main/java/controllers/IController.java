package controllers;

import java.sql.SQLException;

public interface IController {

	String getEnterValue(String basedValue) throws SQLException;
	
}
