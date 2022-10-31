package com.tta.broilers.entities;

import java.util.Date;

public class NecropsyObservation {

	private int necropsy_observation_id;
	private Date creation_date;
	private String description;
	public int getNecropsy_observation_id() {
		return necropsy_observation_id;
	}
	public void setNecropsy_observation_id(int necropsy_observation_id) {
		this.necropsy_observation_id = necropsy_observation_id;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "NecropsyObservation [necropsy_observation_id=" + necropsy_observation_id + ", creation_date="
				+ creation_date + ", description=" + description + "]";
	} 

	

}
