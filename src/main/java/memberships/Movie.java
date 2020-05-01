package memberships;

import entities.AccessRule;
import entities.Membership;

public class Movie extends Membership {
	
	private AccessRule rule;

	public Movie(int id, String description) {
		super(id, description, Membership.Type.VL);
		this.rule = new AccessRule(description, 
				Membership.Type.VL);
	}

	@Override
	public AccessRule getRules() {
		return rule;
	}

}
