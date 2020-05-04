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
	public int insertCard(Card card) throws SQLException {
            int type_id = (int) this.db.query("SELECT id FROM card_types WHERE description='"
                    + String.valueOf(card.getType()) + "';").get(0).get("id");

            String sql = "INSERT INTO cards(id, user_id, type_id) OUTPUT Inserted.ID VALUES(null, #1, #2);";
            return this.db.insert(sql, card.getUser(), type_id);
	}

	@Override
	public void deleteCard(Card card) throws SQLException {
            String sql = "DELETE FROM cards WERE id=#1;";
            this.db.update(sql, card.getUser());
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
