package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class VisitTasks {

	private int taskId;
	private String visitId;

	private double measure;
	private String standard;
	private String deviation;
	private String actionPlan;
	private  int ageFlock;
	private double percentage;
	private  int breedId;
	
	
	private Task task;
	private Visit visit;

	private Date creationDate;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getMeasure() {
		return measure;
	}

	public void setMeasure(double measure) {
		this.measure = measure;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDeviation() {
		return deviation;
	}

	public void setDeviation(String deviation) {
		this.deviation = deviation;
	}

	public String getActionPlan() {
		return actionPlan;
	}

	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	

	public int getAgeFlock() {
		return ageFlock;
	}

	public void setAgeFlock(int ageFlock) {
		this.ageFlock = ageFlock;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getBreedId() {
		return breedId;
	}

	public void setBreedId(int breedId) {
		this.breedId = breedId;
	}

	@Override
	public String toString() {
		return "VisitTasks [taskId=" + taskId + ", visitId=" + visitId + ", measure=" + measure + ", standard="
				+ standard + ", deviation=" + deviation + ", actionPlan=" + actionPlan + ", ageFlock=" + ageFlock
				+ ", percentage=" + percentage + ", breedId=" + breedId + ", task=" + task + ", visit=" + visit
				+ ", creationDate=" + creationDate + "]";
	}

}
