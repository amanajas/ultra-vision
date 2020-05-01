package memberships;

import entities.AccessRule;
import entities.Membership;

public class Boxset extends Membership {
	
	private AccessRule rule;

	public Boxset(int id, String description) {
		super(id, description, Membership.Type.TV);
		this.rule = new AccessRule(description, 
				Membership.Type.TV);
	}

	@Override
	public AccessRule getRules() {
		return rule;
	}

}
