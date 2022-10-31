package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class VisitAudits {
	
    private String visitId ;
	private int breedingMnagementId ;
	private boolean measure ;
	private Date creationDate ;
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public int getBreedingMnagementId() {
		return breedingMnagementId;
	}
	public void setBreedingMnagementId(int breedingMnagementId) {
		this.breedingMnagementId = breedingMnagementId;
	}
	
	public boolean getMeasure() {
		return measure;
	}
	public void setMeasure(boolean measure) {
		this.measure = measure;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
