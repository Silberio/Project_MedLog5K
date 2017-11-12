package com.silberio.model;

/**
 * A patient object
 * 
 * @author silberio_stalone
 *
 */
public class PatientObject implements Comparable<PatientObject>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String address;
	private String dateOfBirth;
	private String telephone;
	private String patientLog;
	private String signedBy;
	private String prescription;
	private String prescriptionReason;
	
	private int prio = 0;
	
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

	public String getPatientLog() {
		return patientLog;
	}

	public void setPatientLog(String patientLog) {
		this.patientLog = patientLog;
	}

	public String getSignedBy() {
		return "Dr. " + signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getPrescriptionReason() {
		return prescriptionReason;
	}

	public void setPrescriptionReason(String prescriptionReason) {
		this.prescriptionReason = prescriptionReason;
	}
	

	public int getPrio() {
		return prio;
	}

	public void setPrio(int prio) {
		this.prio = prio;
	}

	/**
	 * Patient toString() representation
	 */
	@Override
	public String toString() {
		String str = "Patient: " + lastName + ", " + firstName + ". Signed by: " + signedBy;
		return str;
	}

	@Override
	public int compareTo(PatientObject o) {
		if(this.equals(o)) {
			return 0;
		} else if(getPrio() > o.getPrio()) {
			return 1;
		} else
			return -1;
	}


}
