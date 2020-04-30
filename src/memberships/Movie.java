package memberships;

import entities.AccessRule;
import entities.Membership;

public class Movie extends Membership {
	
	private AccessRule rule;

	public Movie() {
		super("(VL) Movie", Membership.Type.VL);
		this.rule = new AccessRule("Movie", 
				Membership.Type.VL);
	}

	@Override
	public AccessRule getRules() {
		return rule;
	}

}
