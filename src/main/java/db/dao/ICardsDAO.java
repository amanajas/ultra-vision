package db.dao;

import java.sql.SQLException;
import java.util.List;

import entities.Card;

public interface ICardsDAO {
	
	int insertCard(Card card) throws SQLException;
	void deleteCard(int cardId) throws SQLException;
	List<Card> get(int userId) throws SQLException;
}
