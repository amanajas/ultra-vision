package memberships;

import entities.AccessRule;
import entities.Membership;

public class Premium extends Membership {
	
	private AccessRule rule;

	public Premium(int id, String description) {
		super(id, description, Membership.Type.PR);
		this.rule = new AccessRule(description, 
				Membership.Type.ML,
				Membership.Type.VL,
				Membership.Type.TV,
				Membership.Type.PR
				);
	}

	@Override
	public AccessRule getRules() {
		return rule;
	}

}
