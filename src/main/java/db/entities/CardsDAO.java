package db.entities;

import java.sql.SQLException;
import java.util.List;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.ICardsDAO;
import entities.Card;
import entities.User;

public class CardsDAO extends DAO implements ICardsDAO {

	public CardsDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertCard(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCard(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCard(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Card> get(int user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
