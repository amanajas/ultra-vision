package memberships;

import entities.AccessRule;
import entities.Membership;

public class Boxset extends Membership {
	
	private AccessRule rule;

	public Boxset() {
		super("(TV) Boxset", Membership.Type.TV);
		this.rule = new AccessRule("Boxset", 
				Membership.Type.TV);
	}

	@Override
	public AccessRule getRules() {
		return rule;
	}

}
