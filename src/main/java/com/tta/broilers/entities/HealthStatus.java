package com.tta.broilers.entities;

import java.util.Date;

public class HealthStatus {

	
	private int healthStatusId;
	private String description;
	private String category;
	private Date creationDate;
	
	
	
	
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getHealthStatusId() {
		return healthStatusId;
	}
	public void setHealthStatusId(int healthStatusId) {
		this.healthStatusId = healthStatusId;
	}
	@Override
	public String toString() {
		return "HealthStatus [healthStatusId=" + healthStatusId + ", description=" + description + ", category="
				+ category + ", creationDate=" + creationDate + "]";
	}
	
 
	
	

	
	
	
	
}
