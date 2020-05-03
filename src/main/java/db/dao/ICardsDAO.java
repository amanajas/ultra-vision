package db.dao;

import java.sql.SQLException;
import java.util.List;

import entities.Card;

public interface ICardsDAO {
	
	boolean insertCard(Card card) throws SQLException;
	boolean updateCard(Card card) throws SQLException;
	boolean deleteCard(Card card) throws SQLException;
	List<Card> get(int user) throws SQLException;
}
