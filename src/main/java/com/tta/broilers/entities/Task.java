package com.tta.broilers.entities;

import java.util.Date;

public class Task {
	
	private int taskId;
	private String description;
	private String category;
	private String measureUnit;
	private Date creationDate;
 
 
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
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
	public String getMeasureUnit() {
		return measureUnit;
	}
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", description=" + description + ", category=" + category + ", measureUnit="
				+ measureUnit + ", creationDate=" + creationDate +  "]";
	}
	
	

	
	
	
	
}
