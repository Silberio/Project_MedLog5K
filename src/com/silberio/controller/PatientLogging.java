package com.silberio.controller;

import org.bson.Document;

import com.silberio.model.PatientObject;
import com.silberio.view.UserInterfaceMethods;

/**
 * Class containing methods for patient logging.
 * <p>
 * This class will be used solely for creating and manipulating patient files.
 * </p>
 * 
 * @author silberio_stalone
 *
 */
public class PatientLogging extends Logging {

	private static PatientLogging instance = null;

	private PatientObject newPatient = new PatientObject();

	private Document patientDocument;

	private String patientID;
	private String documentTitle;

	/**
	 * returns an intance of PatientLogging
	 * 
	 * @return
	 */
	public static PatientLogging getInstance() {
		if (instance == null) {
			instance = new PatientLogging();
		}
		return instance;
	}
	
	/**
	 * creates a new patient and inserts attributes from user
	 */
	@Override
	public void createLoggingObject() {
		UserInterfaceMethods ui = new UserInterfaceMethods();

		ui.userInput("doctor last name");
		newPatient.doctorSignature(ui.getInput());
		ui.userInput("first name");
		newPatient.setFirstName(ui.getInput());
		ui.userInput("last name");
		newPatient.setLastName(ui.getInput());
		ui.userInput("address");
		newPatient.setAddress(ui.getInput());
		ui.userInput("DoB");
		newPatient.setDateOfBirth("date of birth");
		ui.userInput("patient log");
		newPatient.setPatientLog(ui.getInput());
		ui.userInput("medication name");
		newPatient.setPrescription(ui.getInput());
		ui.userInput("reason for prescription");
		newPatient.setReason(ui.getInput());

		System.out.println(newPatient.toString());

	}

	/**
	 * Takes in a patient object and sets it into a MongoDB document
	 * 
	 * @param patient
	 *            the patient object to input into database
	 */
	public void patientObjectToDocument(PatientObject patient) {

		documentTitle = "Patient" + patient.getLastName() + patient.getFirstName();
		patientID = "id" + patient.getLastName() + patient.getDateOfBirth();

		patientDocument = new Document("title", documentTitle).append("id", patientID)
				.append("first_name", patient.getFirstName()).append("last_name", patient.getLastName())
				.append("address", patient.getAddress()).append("DoB", patient.getDateOfBirth())
				.append("phone", patient.getTelephone()).append("patient_log", patient.getPatientLog())
				.append("prescription", patient.getPrescription());

		System.out.println("Patient file created succesfully!");
	}

	public Document getPatientDocument() {
		return patientDocument;
	}

	public PatientObject getPatient() {
		return newPatient;
	}

}
