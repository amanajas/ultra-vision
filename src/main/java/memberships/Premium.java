package memberships;

import entities.AccessRule;
import entities.Membership;

public class Premium extends Membership {
	
	private AccessRule rule;

	public Premium() {
		super("(PR) Premium", Membership.Type.PR);
		this.rule = new AccessRule("Premium", 
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
