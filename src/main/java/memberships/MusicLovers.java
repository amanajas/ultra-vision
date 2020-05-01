package memberships;

import entities.AccessRule;
import entities.Membership;

public class MusicLovers extends Membership {
	
	private AccessRule rule;

	public MusicLovers(int id, String description) {
		super(id, description, Membership.Type.ML);
		this.rule = new AccessRule("Music Lovers", 
				Membership.Type.ML);
	}

	@Override
	public AccessRule getRules() {
		return rule;
	}

}
