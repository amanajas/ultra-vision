/**
 * 
 */
package entities;

/**
 * @author thiago.amanajas
 *
 */
public class User {
	
	private String name;
	private Membership membership;
	
	public User(String name) {
		this(name, null);
	}
	
	public User(String name, Membership membership) {
		this.name = name;
		this.membership = membership;
	}
	
	public String getName() {
		return name;
	}
	public Membership getMembership() {
		return this.membership;
	}
}
