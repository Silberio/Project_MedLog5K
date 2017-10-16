package com.silberio.model;

public class PrescriptionObject {
	private String medicationName;
	private String medicationReason;
	private String medicationDosage;
	private String medicationActiveIngr;
	private String issueDate;
	private String expiryDate;
	private String writtenBy;

	public PrescriptionObject() {

	}

	public PrescriptionObject(String medicationName, String medicationReason, String writtenBy) {
		this.medicationName = medicationName;
		this.medicationReason = medicationReason;
		this.writtenBy = writtenBy;
	}

	public PrescriptionObject(String medicationName, String medicationReason, String medicationDosage,
			String medicationActiveIngr, String issueDate, String expiryDate, String writtenBy) {
		this.medicationName = medicationName;
		this.medicationReason = medicationReason;
		this.medicationDosage = medicationDosage;
		this.medicationActiveIngr = medicationActiveIngr;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.writtenBy = writtenBy;
	}

	/*
	 * GETERS AND SETTERS
	 */
	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getMedicationReason() {
		return medicationReason;
	}

	public void setMedicationReason(String medicationReason) {
		this.medicationReason = medicationReason;
	}

	public String getMedicationDosage() {
		return medicationDosage;
	}

	public void setMedicationDosage(String medicationDosage) {
		this.medicationDosage = medicationDosage;
	}

	public String getMedicationActiveIngr() {
		return medicationActiveIngr;
	}

	public void setMedicationActiveIngr(String medicationActiveIngr) {
		this.medicationActiveIngr = medicationActiveIngr;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getWrittenBy() {
		return writtenBy;
	}

	public void setWrittenBy(String writtenBy) {
		this.writtenBy = writtenBy;
	}

	
}
