package db.entities;

import java.sql.SQLException;
import java.util.List;

import db.SQLDatabase;
import db.dao.DAO;
import db.dao.ICardsDAO;
import entities.Card;
import java.util.ArrayList;
import java.util.Map;

public class CardsDAO extends DAO implements ICardsDAO {

	public CardsDAO(SQLDatabase db) {
		super(db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertCard(Card card) throws SQLException {
		String sql = "﻿INSERT INTO cards " +
                "(user_id', 'type_id') " +
                "VALUES (#1, #2);";
                
                String type = (String) this.db.query("SELECT id FROM card_types WHERE description='"
                        + "'" + String.valueOf(card.getType()) + "';").get(0).get("id");
                        
                
                sql = sql.replace("#2", type);
                sql = sql.replace("#1", String.valueOf(card.getUser()));
                
                System.out.print(this.db.query(sql).toString());
                
		return false;
	}

	@Override
	public boolean updateCard(Card card) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCard(Card card) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Card> get(int user) throws SQLException {
                List<Card> cards = new ArrayList<>();
                List<Map<String, Object>> result = this.db.query("SELECT c.id AS cardId, "
                        + "t.description AS description "
                        + "FROM cards AS c "
                        + "JOIN card_types AS t ON t.id = c.type_id "
                        + "WHERE c.user_id = " + user + ";");
                for(Map<String, Object> map : result){
                    int id = (int) map.get("cardId");
                    Card.Type cardType = Card.Type.valueOf((String) map.get(
                            "description"));
                    cards.add(new Card(id, cardType, user));
                }
		return cards;
	}

}
