package com.silberio.controller;

import org.bson.Document;

import com.silberio.model.DoctorObject;
import com.silberio.view.UserInterfaceMethods;

/**
 * Class containing methods for logging doctors to their respective mongoDB collection
 * @author silberio_stalone
 *
 */
public class DoctorLogging extends Logging {
	
	private static DoctorLogging instance = null;
	
	private DoctorObject doctor = new DoctorObject();	
	private Document doctorDocument;
	
	private String doctorID;
	private String documentTitle;
	/**
	 * returns an intance of DoctorLogging
	 * 
	 * @return instance of DoctorLogging
	 */
	public static DoctorLogging getInstance() {
		if (instance == null) {
			instance = new DoctorLogging();
		}
		return instance;
	}
	
	/**
	 * Creates a doctor object with user input
	 */
	@Override
	public void createLoggingObject() {
		UserInterfaceMethods ui = new UserInterfaceMethods();
		
		ui.userInput("doctor first name");
		doctor.setFirstName(ui.getInput());
		ui.userInput("doctor last name");
		doctor.setLastName(ui.getInput());
		ui.userInput("telephone");
		doctor.setTelephone(ui.getInput());
		ui.userInput("date of birth");
		doctor.setDoB(ui.getInput());
		ui.userInput("hospital of employment");
		doctor.setHospital(ui.getInput());
		
		System.out.println(doctor.toString());
	}
	
	/**
	 * 
	 * @param doctor
	 */
	public void doctorObjectToDocument(DoctorObject doctor) {
		
		documentTitle = doctor.getLastName() + "_PersonalFile";
		
		doctorID = doctor.getLastName() + doctor.getDoB() + "_" + doctor.getHospital();

		doctorDocument = new Document("title", documentTitle)
				.append("id", doctorID)
				.append("first_name", doctor.getFirstName())
				.append("last_name", doctor.getLastName())
				.append("DoB", doctor.getDoB())
				.append("phone", doctor.getTelephone());
		System.out.println("Patient file created succesfully!");
	}
	
	/*
	 * 
	 */
	
	/**
	 * retrieve the doctor MongoDB document
	 * @return a document to input into a collection
	 */
	public Document getDoctorDocument() {
		return doctorDocument;
	}
	
	/**
	 * gets a (hopefully) initialized doctor object
	 * @return doctor object
	 */
	public DoctorObject getDoctorObject() {
		return doctor;
	}
}
