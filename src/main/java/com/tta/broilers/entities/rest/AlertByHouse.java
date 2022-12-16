package com.tta.broilers.entities.rest;

public class AlertByHouse {
	private int count;
	private int taskId;
	private String description;
	private String deviation;
	private String mesures;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
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
	public String getDeviation() {
		return deviation;
	}
	public void setDeviation(String deviation) {
		this.deviation = deviation;
	}
	public String getMesures() {
		return mesures;
	}
	public void setMesures(String mesures) {
		this.mesures = mesures;
	}
	@Override
	public String toString() {
		return "AlertByHouse [count=" + count + ", taskId=" + taskId + ", description=" + description + ", deviation="
				+ deviation + ", mesures=" + mesures + "]";
	}
	
	
	

}
