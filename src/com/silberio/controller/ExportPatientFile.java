package com.silberio.controller;

import com.silberio.model.PatientObject;

public class ExportPatientFile {
	private String patientFile;
	
	public void formatPatientFile(PatientObject patient) {
		patientFile = patient.getLastName() + ", " + patient.getLastName();
	}
	
	public String getPatientFile() {
		return patientFile;
	}

	public void setPatientFile(String patientFile) {
		this.patientFile = patientFile;
	}
	
	
	
}
