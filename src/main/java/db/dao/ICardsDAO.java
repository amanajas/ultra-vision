package db.dao;

import java.sql.SQLException;
import java.util.List;

import entities.Card;

public interface ICardsDAO {
	
	int insertCard(Card card) throws SQLException;
	void deleteCard(Card card) throws SQLException;
	List<Card> get(int user) throws SQLException;
}
