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
	
	public static final int NEW_USER = -1;
	
	private int id;
	private String name;
	private Membership membership;
	private List<Card> cards;
	private LoyaltyPoints points;
	
	
	public User(String name, LoyaltyPoints loyalty) {
		this(NEW_USER, name, loyalty, null, null);
	}
	
	public User(int id, String name, LoyaltyPoints loyalty) {
		this(id, name, loyalty, null, null);
	}
	
	public User(int id, String name, LoyaltyPoints loyalty, Card card, Membership membership) {
		this.id = id;
		this.name = name;
		this.setCard(card);
		this.points = loyalty;
		this.membership = membership;
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

	public LoyaltyPoints getLoyalty() {
		return points;
	}
}
