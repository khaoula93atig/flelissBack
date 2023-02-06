package com.tta.broilers.entities.rest;

import java.util.Date;

public class MortalityByhouseLastDays {
	
	private int mesure;
	private Date date;
	public int getMesure() {
		return mesure;
	}
	public void setMesure(int mesure) {
		this.mesure = mesure;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MortalityByhouseLastDays [mesure=" + mesure + ", date=" + date + "]";
	}
	
	

}
