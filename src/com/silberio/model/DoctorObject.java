package com.silberio.model;

import java.io.Serializable;

public class DoctorObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String telephone;
	private String DoB;
	private String hospital;

	public DoctorObject() {

	}

	public DoctorObject(String firstName, String lastName, String telephone, String DoB, String hospital) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.DoB = DoB;
		this.hospital = hospital;

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String doB) {
		DoB = doB;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	/**
	 * toString method
	 * 
	 * @return string with doc name and hospital they're stationed at
	 */
	@Override
	public String toString() {
		String str = "Dr." + this.lastName + ", M.D. at " + this.hospital;
		return str;
	}
}
