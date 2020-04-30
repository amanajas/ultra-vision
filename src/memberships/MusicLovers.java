package memberships;

import entities.AccessRule;
import entities.Membership;

public class MusicLovers extends Membership {
	
	private AccessRule rule;

	public MusicLovers() {
		super("(ML) Music Lovers", Membership.Type.ML);
		this.rule = new AccessRule("Music Lovers", 
				Membership.Type.ML);
	}

	@Override
	public AccessRule getRules() {
		return rule;
	}

}
