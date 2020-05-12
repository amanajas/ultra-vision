package entities;

import java.util.Date;

public class Card implements IEntity{

    public static int POINTS = 10;

    	public enum Type {
		Credit, Debit
	}
	
	private int id;
	private Type type;
	private int user;
        private String number;
        private Date expirationDate;
	
        public Card(Type type, int user) {
            this(-1, type, user);
        }
        
	public Card(int id, Type type, int user) {
		this.id = id;
		this.type = type;
		this.user = user;
	}
        
        public void addCardNumber(String number, Date expiration) {
            this.number = number;
            this.expirationDate = expiration;
        }
        
        public String getNumber() {
            return this.number;
        }
        
        public long getExpirationDate() {
            return this.expirationDate.getTime();
        }
	
	public int getId() {
		return this.id;
	}
	
	public Type getType() {
		return type;
	}
	
	public int getUser() {
		return user;
	}
        
        public void setId(int id) {
            this.id = id;
        }

		@Override
		public String getDescription() {
			return this.number;
		}
}
