/**
 * 
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thiago.amanajas
 *
 */
public class User {
	
	private int id;
	private String name;
        private String password;
	private Membership membership;
	private List<Card> cards;
	private LoyaltyPoints points;
	
	public User(int id, String name, LoyaltyPoints loyalty, Membership membership, List<Card> list) {
		this.id = id;
		this.name = name;
		this.setCard(list);
		this.points = loyalty;
		this.membership = membership;
	}
        
        public void setPassword(String password) {
            this.password = password;
        }
        
        public String getPassword() {
            return password;
        }
	
	public String getName() {
		return name;
	}
	
	public Membership getMembership() {
		return this.membership;
	}
	
	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCard(Card card) {
		if(this.cards == null) {
			this.cards = new ArrayList<Card>();
		}
		this.cards.add(card);
	}
	
	public void setCard(List<Card> cards) {
		this.cards = cards;
	}

	public LoyaltyPoints getLoyalty() {
		return points;
	}

	public void setName(String name) {
		this.name = name;		
	}
}
