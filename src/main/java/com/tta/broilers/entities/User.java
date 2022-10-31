package com.tta.broilers.entities;

import java.util.Date;
import java.util.List;


/**
 * @author rym lamouchi
 *
 */

public class User {
	private String username; // id
	private String password;
	private String job;
	private String email;
	private String name;


	private String farmID;
	private String companyID;
	private String telNumber;
	private Date creationDate;
	private Farm farm;
	private Company company;
	private String role;

	private List<UserPermission> permissions;
	private Role roleObject;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getFarmID() {
		return farmID;
	}

	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public List<UserPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<UserPermission> permissions) {
		this.permissions = permissions;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role getRoleObject() {
		return roleObject;
	}

	public void setRoleObject(Role roleObject) {
		this.roleObject = roleObject;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", job=" + job + ", email=" + email + ", name="
				+ name + ", farmID=" + farmID + ", companyID=" + companyID + ", telNumber=" + telNumber
				+ ", creationDate=" + creationDate + ", farm=" + farm + ", company=" + company + ", role=" + role
				+ ", permissions=" + permissions + ", roleObject=" + roleObject + "]";
	}



	

	







	

}
