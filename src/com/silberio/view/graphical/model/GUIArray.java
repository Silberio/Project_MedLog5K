package com.silberio.view.graphical.model;

import java.util.ArrayList;
import java.util.List;

public class GUIArray {

	private static GUIArray instance = null;

	private List<List<String>> list = new ArrayList<>();

	private String firstName;
	private String lastName;
	private String address;
	private String dateOfBirth;
	private String telephone;
	private String patientLog;
	private String signedBy;
	private String prescription;
	private String prescriptionReason;
	
	public static GUIArray getInstance() {
		if (instance == null) {
			instance = new GUIArray();
		}
		return instance;
	}

	public void initArray() {
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.get(0).add("firstName");
		list.get(0).add("lastName");
		list.get(0).add("address");
		list.get(0).add("dateOfBirth");
		list.get(0).add("telephone");
		list.get(0).add("patientLog");
		list.get(0).add("signedBy");
		list.get(0).add("prescription");
		list.get(0).add("prescriptionReason");

	}
	
	public void addPatientToArray(int row, String input) {
		list.get(row).add(input);
	}
	
	/*
	 * 
	 * GETTERS & SETTERS
	 * 
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
		return signedBy;
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

	public static void setInstance(GUIArray instance) {
		GUIArray.instance = instance;
	}

	/**
	 * returns a text representation of the table
	 */
	public String toString() {
		String str = null;

		for (List<String> l1 : list) {
			for (String n : l1) {
				str += n + " | ";
			}
		}
		
		return str;
	}

}
