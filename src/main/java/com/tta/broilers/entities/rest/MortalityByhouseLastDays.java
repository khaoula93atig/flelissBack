package com.tta.broilers.entities.rest;

import java.util.Date;

public class MortalityByhouseLastDays {
	
	private int mesure;
	private String dateAge;
	private Date visitDate;

	public int getMesure() {
		return mesure;
	}

	public void setMesure(int mesure) {
		this.mesure = mesure;
	}

	public String getDateAge() {
		return dateAge;
	}

	public void setDateAge(String dateAge) {
		this.dateAge = dateAge;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	@Override
	public String toString() {
		return "MortalityByhouseLastDays{" +
				"mesure=" + mesure +
				", dateAge='" + dateAge + '\'' +
				", visitDate=" + visitDate +
				'}';
	}
}
