package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author Emna
 *
 */
public class VisitHealthStatus {
	 private String visitHealthStatusID;
    private String visitId ;
	private boolean prostration ;
	private boolean anorexia ;
	private boolean ruffledFeather ;
	private boolean dehydratation ;
	private String generalObservation ;
	private boolean coughing ;
	private boolean nasalExsudate ;
	private boolean sneezing ;
	private boolean trachealRales ;
	private boolean ocularDischarge ;
	private boolean conjonctivitis ;
	private boolean oedema ;
	private String respiratoryObservation ;
	private boolean diarrhoea ;
	private boolean whitish ;
	private boolean watery ;
	private boolean mucoid ;
	private boolean greenish ;
	private String digestiveObservation ;
	private String locomotionObservation ;
	private String nervous ;
	private String dermatitis ;
	private String otherObservation ;
	private Date creationDate ;
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public boolean isProstration() {
		return prostration;
	}
	public void setProstration(boolean prostration) {
		this.prostration = prostration;
	}
	public boolean isAnorexia() {
		return anorexia;
	}
	public void setAnorexia(boolean anorexia) {
		this.anorexia = anorexia;
	}
	public boolean isRuffledFeather() {
		return ruffledFeather;
	}
	public void setRuffledFeather(boolean ruffledFeather) {
		this.ruffledFeather = ruffledFeather;
	}
	public boolean isDehydratation() {
		return dehydratation;
	}
	public void setDehydratation(boolean dehydratation) {
		this.dehydratation = dehydratation;
	}
	public String getGeneralObservation() {
		return generalObservation;
	}
	public void setGeneralObservation(String generalObservation) {
		this.generalObservation = generalObservation;
	}
	public boolean isCoughing() {
		return coughing;
	}
	public void setCoughing(boolean coughing) {
		this.coughing = coughing;
	}
	public boolean isNasalExsudate() {
		return nasalExsudate;
	}
	public void setNasalExsudate(boolean nasalExsudate) {
		this.nasalExsudate = nasalExsudate;
	}
	public boolean isSneezing() {
		return sneezing;
	}
	public void setSneezing(boolean sneezing) {
		this.sneezing = sneezing;
	}
	public boolean isTrachealRales() {
		return trachealRales;
	}
	public void setTrachealRales(boolean trachealRales) {
		this.trachealRales = trachealRales;
	}
	public boolean isOcularDischarge() {
		return ocularDischarge;
	}
	public void setOcularDischarge(boolean ocularDischarge) {
		this.ocularDischarge = ocularDischarge;
	}
	public boolean isConjonctivitis() {
		return conjonctivitis;
	}
	public void setConjonctivitis(boolean conjonctivitis) {
		this.conjonctivitis = conjonctivitis;
	}
	public boolean isOedema() {
		return oedema;
	}
	public void setOedema(boolean oedema) {
		this.oedema = oedema;
	}
	public String getRespiratoryObservation() {
		return respiratoryObservation;
	}
	public void setRespiratoryObservation(String respiratoryObservation) {
		this.respiratoryObservation = respiratoryObservation;
	}
	public boolean isDiarrhoea() {
		return diarrhoea;
	}
	public void setDiarrhoea(boolean diarrhoea) {
		this.diarrhoea = diarrhoea;
	}
	public boolean isWhitish() {
		return whitish;
	}
	public void setWhitish(boolean whitish) {
		this.whitish = whitish;
	}
	public boolean isWatery() {
		return watery;
	}
	public void setWatery(boolean watery) {
		this.watery = watery;
	}
	public boolean isMucoid() {
		return mucoid;
	}
	public void setMucoid(boolean mucoid) {
		this.mucoid = mucoid;
	}
	public boolean isGreenish() {
		return greenish;
	}
	public void setGreenish(boolean greenish) {
		this.greenish = greenish;
	}
	public String getDigestiveObservation() {
		return digestiveObservation;
	}
	public void setDigestiveObservation(String digestiveObservation) {
		this.digestiveObservation = digestiveObservation;
	}
	public String getLocomotionObservation() {
		return locomotionObservation;
	}
	public void setLocomotionObservation(String locomotionObservation) {
		this.locomotionObservation = locomotionObservation;
	}
	public String getNervous() {
		return nervous;
	}
	public void setNervous(String nervous) {
		this.nervous = nervous;
	}
	public String getDermatitis() {
		return dermatitis;
	}
	public void setDermatitis(String dermatitis) {
		this.dermatitis = dermatitis;
	}
	public String getOtherObservation() {
		return otherObservation;
	}
	public void setOtherObservation(String otherObservation) {
		this.otherObservation = otherObservation;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getVisitHealthStatusID() {
		return visitHealthStatusID;
	}
	public void setVisitHealthStatusID(String visitHealthStatusID) {
		this.visitHealthStatusID = visitHealthStatusID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VisitHealthStatus [visitHealthStatusID=");
		builder.append(visitHealthStatusID);
		builder.append(", visitId=");
		builder.append(visitId);
		builder.append(", prostration=");
		builder.append(prostration);
		builder.append(", anorexia=");
		builder.append(anorexia);
		builder.append(", ruffledFeather=");
		builder.append(ruffledFeather);
		builder.append(", dehydratation=");
		builder.append(dehydratation);
		builder.append(", generalObservation=");
		builder.append(generalObservation);
		builder.append(", coughing=");
		builder.append(coughing);
		builder.append(", nasalExsudate=");
		builder.append(nasalExsudate);
		builder.append(", sneezing=");
		builder.append(sneezing);
		builder.append(", trachealRales=");
		builder.append(trachealRales);
		builder.append(", ocularDischarge=");
		builder.append(ocularDischarge);
		builder.append(", conjonctivitis=");
		builder.append(conjonctivitis);
		builder.append(", oedema=");
		builder.append(oedema);
		builder.append(", respiratoryObservation=");
		builder.append(respiratoryObservation);
		builder.append(", diarrhoea=");
		builder.append(diarrhoea);
		builder.append(", whitish=");
		builder.append(whitish);
		builder.append(", watery=");
		builder.append(watery);
		builder.append(", mucoid=");
		builder.append(mucoid);
		builder.append(", greenish=");
		builder.append(greenish);
		builder.append(", digestiveObservation=");
		builder.append(digestiveObservation);
		builder.append(", locomotionObservation=");
		builder.append(locomotionObservation);
		builder.append(", nervous=");
		builder.append(nervous);
		builder.append(", dermatitis=");
		builder.append(dermatitis);
		builder.append(", otherObservation=");
		builder.append(otherObservation);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		return builder.toString();
	}



	
	
	
	
	
	
	
	
	
	
}
