package entities;

import java.util.List;

public class AccessRule {
	
	private String description;
	private List<Membership.Type> accessTo;
	
	public AccessRule(String description, List<Membership.Type> accessTo) {
		this.description = description;
		this.accessTo = accessTo;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public List<Membership.Type> getAccess() {
		return this.accessTo;
	}

}
