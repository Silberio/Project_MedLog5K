package com.silberio.model;

public class PatientObject {
	private String firstName;
	private String lastName;
	private String address;
	private String dateOfBirth;
	private String telephone;
	private String patientLog;
	private String signedBy;
	private String prescription;
	private String prescriptionReason;

	public PatientObject() {

	}

	/**
	 * Creates the base for a new patient.
	 * <p>
	 * log and prescription are added through own methods, as well as signed by
	 * property
	 * </p>
	 * 
	 * @param firstName
	 *            the first name of the patient.
	 * @param lastname
	 *            the last name of the patient
	 * @param address
	 *            the address of the patient
	 * @param DoB
	 *            date of birth
	 * @param telephone
	 *            telephone
	 */

	public PatientObject(String firstName, String lastname, String address, String DoB, String telephone) {
		this.firstName = firstName;
		this.lastName = lastname;
		this.address = address;
		this.dateOfBirth = DoB;
		this.telephone = telephone;
	}

	/**
	 * Stores the patient log.
	 * 
	 * @param log
	 *            the log itself written by doctor.
	 */
	public void setPatientLog(String log) {
		this.patientLog = log;
	}

	/**
	 * returns the written patient log
	 * 
	 * @return log file written by doctor
	 */
	public String getPatientLog() {
		String str = "File: " + patientLog;
		return str;
	}

	/**
	 * Stores a prescription log given by doctor
	 * 
	 * @param prescription
	 *            the prescription itself
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	/**
	 * Stores a short reason for prescribing a medication
	 * @param reason short reason
	 */
	public void setReason(String reason) {
		this.prescriptionReason = reason;
	}

	/**
	 * returns the prescription given by doctor, with the reason
	 * 
	 * @return the precription log for a given patient
	 */
	public String getPrescription() {
		String str = "Prescribed: " + prescription + "\n" + prescriptionReason;
		return str;
	}

	/**
	 * sets doctor signature. Only last name required (or full name) as title is
	 * added by program itself.
	 * 
	 * @param doctorName
	 *            name of doctor who signed log
	 */
	public void doctorSignature(String doctorName) {
		this.signedBy = "Dr." + doctorName;
	}

	/**
	 * returns signature of doctor.
	 * 
	 * @return the string of doctor name and title
	 */
	public String getSignedBy() {
		return signedBy;
	}
	/*
	 * GETTERS AND SETTERS
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Patient toString() representation
	 */
	@Override
	public String toString() {
		String str = "Patient: " + lastName + ", " + firstName + ". Signed by: " + signedBy;
		return str;
	}

}
