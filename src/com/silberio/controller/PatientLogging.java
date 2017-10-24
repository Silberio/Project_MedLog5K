package com.silberio.controller;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.connection.Connection;
import com.silberio.model.PatientObject;
import com.silberio.view.graphical.control.GraphicalUserInterfaceMethods;

/**
 * Class containing methods for logging patients to their respective mongoDB
 * collection
 * <p>
 * This class extends abstract class <b>Logging</b> and makes use of the
 * abstract method <b>createLoggingObject</b>, which receives an entity, in this
 * case a doctor, which it stores as an object.
 * </p>
 * <p>
 * these objects can later be manipulated and made into MongoDB documents.
 * <b>Logging</b> has the method <i>insertDocument</i> which is implemented
 * here.
 * </p>
 *
 * <ul>
 * <b>Methods:</b>
 * <li><b>getInstance();</b> initiates a single instance of PatientLogging</li>
 * </ul>
 * <li><b>createLoggingObject()</b> creates an object that'll go into the
 * logging system</li>
 * <li><b>patientObjectToDocument()</b> turns object into a document to be
 * inserted or manipulated by MongoDB</li>
 * <li><b>Getters and Setters</b> for patient object and document</li>
 * 
 * @author silberio_stalone
 *
 */
public class PatientLogging extends Logging {

	private static PatientLogging instance = null;	
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
	/* END singleton instantiation */
	
	 
	private static GraphicalUserInterfaceMethods GUIMethods = GraphicalUserInterfaceMethods.getInstance();
	
	private PatientObject patient;

	private Document patientDocument;

	private String patientID;
	private String documentTitle;
	private MongoCollection<Document> collection;
	
	/**
	 * creates a new patient and inserts attributes from user
	 */
	@Override
	public void createLoggingObject() {		
		System.out.println("patient: " + patient.toString() + ", logged" );
		}
	
	

	/**
	 * Takes in a patient object and sets it into a MongoDB document
	 * 
	 * @param patient
	 *            the patient object to input into database
	 */
	@Override
	public void objectToDocument() {

		documentTitle = "Patient" + patient.getLastName() + patient.getFirstName();
		patientID = "id" + patient.getLastName() + patient.getFirstName();

		patientDocument = new Document("title", documentTitle)
				.append("id", patientID)
				.append("first_name", patient.getFirstName())
				.append("last_name", patient.getLastName())
				.append("address", patient.getAddress())
				.append("DoB", patient.getDateOfBirth())
				.append("phone", patient.getTelephone())
				.append("patient_log", patient.getPatientLog())
				.append("prescription", patient.getPrescription());
	}
	
	public void insertDocument() {
		collection.insertOne(patientDocument);
	}

//		@Override
//		public void objectToDocument() {
//			
//			/*
//			 * USER INTERFACE IN CONSOLE
//			 * ONLY FOR DEBUGGING
//			 */
//			UserInterfaceMethods ui = new UserInterfaceMethods();
//			
//			ui.userInput("doctor last name");
//			patient.doctorSignature(ui.getInput());
//			ui.userInput("first name");
//			patient.setFirstName(ui.getInput());
//			ui.userInput("last name");
//			patient.setLastName(ui.getInput());
//			ui.userInput("address");
//			patient.setAddress(ui.getInput());
//			ui.userInput("DoB");
//			patient.setDateOfBirth("date of birth");
//			ui.userInput("patient log");
//			patient.setPatientLog(ui.getInput());
//			ui.userInput("medication name");
//			patient.setPrescription(ui.getInput());
//			ui.userInput("reason for prescription");
//			patient.setReason(ui.getInput());
//	
//			System.out.println(patient.toString());
//			System.out.println("Patient file created succesfully!");
//		}



	public Document getPatientDocument() {
		return patientDocument;
	}

	public PatientObject getPatient() {
		return patient;
	}

	public void setPatient(PatientObject patient) {
		this.patient = patient;
	}



	public MongoCollection<Document> getCollection() {
		return collection;
	}



	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	

}
