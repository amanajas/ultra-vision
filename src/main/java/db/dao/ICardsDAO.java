package db.dao;

import java.sql.ResultSet;

import entities.Card;
import entities.User;

public interface ICardsDAO {
	
	boolean insertCard(User user);
	boolean updateCard(User user);
	boolean deleteCard(User user);
	ResultSet get(Card card);
}
