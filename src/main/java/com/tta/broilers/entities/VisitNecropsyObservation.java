package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author EMNA
 *
 */
public class VisitNecropsyObservation {
	
	private String visitNecropsyObservationId;  
	private String visitId;
	private String externalExamination;
	private String bones;
	private String legFeet;
	private String trachea;
	private String crop;
	private String thymus;
	private String liver;
	private String spleen;
	private String kidney;
	private String heart;
	private String lung;
	private String gastroIntestinalTract;
	private String bursaFabricius;
	private String brain;
	private Date creationDate;
	
	
	public String getVisitNecropsyObservationId() {
		return visitNecropsyObservationId;
	}
	public void setVisitNecropsyObservationId(String visitNecropsyObservationId) {
		this.visitNecropsyObservationId = visitNecropsyObservationId;
	}
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getExternalExamination() {
		return externalExamination;
	}
	public void setExternalExamination(String externalExamination) {
		this.externalExamination = externalExamination;
	}
	public String getBones() {
		return bones;
	}
	public void setBones(String bones) {
		this.bones = bones;
	}
	public String getLegFeet() {
		return legFeet;
	}
	public void setLegFeet(String legFeet) {
		this.legFeet = legFeet;
	}
	public String getTrachea() {
		return trachea;
	}
	public void setTrachea(String trachea) {
		this.trachea = trachea;
	}
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		this.crop = crop;
	}
	public String getThymus() {
		return thymus;
	}
	public void setThymus(String thymus) {
		this.thymus = thymus;
	}

	public String getLiver() {
		return liver;
	}
	public void setLiver(String liver) {
		this.liver = liver;
	}
	public String getSpleen() {
		return spleen;
	}
	public void setSpleen(String spleen) {
		this.spleen = spleen;
	}
	public String getKidney() {
		return kidney;
	}
	public void setKidney(String kidney) {
		this.kidney = kidney;
	}
	public String getHeart() {
		return heart;
	}
	public void setHeart(String heart) {
		this.heart = heart;
	}
	public String getLung() {
		return lung;
	}
	public void setLung(String lung) {
		this.lung = lung;
	}
	public String getGastroIntestinalTract() {
		return gastroIntestinalTract;
	}
	public void setGastroIntestinalTract(String gastroIntestinalTract) {
		this.gastroIntestinalTract = gastroIntestinalTract;
	}
	public String getBursaFabricius() {
		return bursaFabricius;
	}
	public void setBursaFabricius(String bursaFabricius) {
		this.bursaFabricius = bursaFabricius;
	}
	public String getBrain() {
		return brain;
	}
	public void setBrain(String brain) {
		this.brain = brain;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VisitNecropsyObservation [visitNecropsyObservationId=");
		builder.append(visitNecropsyObservationId);
		builder.append(", visitId=");
		builder.append(visitId);
		builder.append(", externalExamination=");
		builder.append(externalExamination);
		builder.append(", bones=");
		builder.append(bones);
		builder.append(", legFeet=");
		builder.append(legFeet);
		builder.append(", trachea=");
		builder.append(trachea);
		builder.append(", crop=");
		builder.append(crop);
		builder.append(", thymus=");
		builder.append(thymus);
		builder.append(", liver=");
		builder.append(liver);
		builder.append(", spleen=");
		builder.append(spleen);
		builder.append(", kidney=");
		builder.append(kidney);
		builder.append(", heart=");
		builder.append(heart);
		builder.append(", lung=");
		builder.append(lung);
		builder.append(", gastroIntestinalTract=");
		builder.append(gastroIntestinalTract);
		builder.append(", bursaFabricius=");
		builder.append(bursaFabricius);
		builder.append(", brain=");
		builder.append(brain);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	 

	
	


	
	
}
