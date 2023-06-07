package com.tta.broilers.entities;

import java.util.Date;

/**
 * @author rym lamouchi
 *
 */
public class Company {

	private String companyId;

	private String name;
	private boolean integration = true;
	private int farmsNumber = 1;
	private String agreement; // contrat attaché
	private String address = "";
	private String country = "";
	private String zone = "";
	private String logo;
	private String generalManageName = "";
	private String generalManageEmail = "";
	private String generalManageTel = "";
	private String annualProduction; // high, medium or low
	private Date creationDate;

 

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public boolean isIntegration() {
		return integration;
	}

	public void setIntegration(boolean integration) {
		this.integration = integration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFarmsNumber() {
		return farmsNumber;
	}

	public void setFarmsNumber(int farmsNumber) {
		this.farmsNumber = farmsNumber;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getGeneralManageName() {
		return generalManageName;
	}

	public void setGeneralManageName(String generalManageName) {
		this.generalManageName = generalManageName;
	}

	public String getGeneralManageEmail() {
		return generalManageEmail;
	}

	public void setGeneralManageEmail(String generalManageEmail) {
		this.generalManageEmail = generalManageEmail;
	}

	public String getGeneralManageTel() {
		return generalManageTel;
	}

	public void setGeneralManageTel(String generalManageTel) {
		this.generalManageTel = generalManageTel;
	}

	public String getAnnualProduction() {
		return annualProduction;
	}

	public void setAnnualProduction(String annualProduction) {
		this.annualProduction = annualProduction;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((agreement == null) ? 0 : agreement.hashCode());
		result = prime * result + ((annualProduction == null) ? 0 : annualProduction.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + farmsNumber;
		result = prime * result + ((generalManageEmail == null) ? 0 : generalManageEmail.hashCode());
		result = prime * result + ((generalManageName == null) ? 0 : generalManageName.hashCode());
		result = prime * result + ((generalManageTel == null) ? 0 : generalManageTel.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + (integration ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((zone == null) ? 0 : zone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (agreement == null) {
			if (other.agreement != null)
				return false;
		} else if (!agreement.equals(other.agreement))
			return false;
		if (annualProduction == null) {
			if (other.annualProduction != null)
				return false;
		} else if (!annualProduction.equals(other.annualProduction))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (farmsNumber != other.farmsNumber)
			return false;
		if (generalManageEmail == null) {
			if (other.generalManageEmail != null)
				return false;
		} else if (!generalManageEmail.equals(other.generalManageEmail))
			return false;
		if (generalManageName == null) {
			if (other.generalManageName != null)
				return false;
		} else if (!generalManageName.equals(other.generalManageName))
			return false;
		if (generalManageTel == null) {
			if (other.generalManageTel != null)
				return false;
		} else if (!generalManageTel.equals(other.generalManageTel))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (integration != other.integration)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (zone == null) {
			if (other.zone != null)
				return false;
		} else if (!zone.equals(other.zone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", integration=" + integration + ", farmsNumber="
				+ farmsNumber + ", agreement=" + agreement + ", address=" + address + ", country=" + country + ", zone="
				+ zone + ", logo=" + logo + ", generalManageName=" + generalManageName + ", generalManageEmail="
				+ generalManageEmail + ", generalManageTel=" + generalManageTel + ", annualProduction="
				+ annualProduction + ", creationDate=" + creationDate + "]";
	}

}
