package db.dao;

import java.sql.SQLException;
import java.util.List;

import entities.Card;
import entities.User;

public interface ICardsDAO {
	
	boolean insertCard(User user) throws SQLException;
	boolean updateCard(User user) throws SQLException;
	boolean deleteCard(User user) throws SQLException;
	List<Card> get(int user) throws SQLException;
}
