package com.tta.broilers.entities;

/**
 * @author rym lamouchi
 *
 */

public class Role {
	private long roleID; // id
	private String description; //role
     
	
	
	public long getRoleID() {
		return roleID;
	}
	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
