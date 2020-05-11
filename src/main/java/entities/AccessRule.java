package entities;

public class AccessRule {
	
	private String description;
	private Membership.Type[] accessTo;
	
	public AccessRule(String description, Membership.Type... accessTo) {
		this.description = description;
		this.accessTo = accessTo;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Membership.Type[] getAccess() {
		return this.accessTo;
	}
	
	public String getAccessString() {
		String access = "";
		for (int i = 0; i < accessTo.length; i++) {
			access += String.valueOf(accessTo[i]) + " ";
		}
		return access;
	}

}
