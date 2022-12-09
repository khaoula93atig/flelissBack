package com.tta.broilers.entities.rest;

public class AlertByFarm {
	private int count;
	private int taskId;
	private String houseId;
	private String centerId;
	private String houseName;
	private String centerName;
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
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
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
		return "AlertByFarm [count=" + count + ", taskId=" + taskId + ", houseId=" + houseId + ", centerId=" + centerId
				+ ", houseName=" + houseName + ", centerName=" + centerName + ", description=" + description
				+ ", deviation=" + deviation + ", mesures=" + mesures + "]";
	}
	
	

}
