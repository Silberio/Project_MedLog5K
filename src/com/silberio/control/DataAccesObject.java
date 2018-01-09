package com.silberio.control;

import java.util.PriorityQueue;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.silberio.model.Patient;

public class DataAccesObject implements DataAccesObjectImpl {
	private static DataAccesObject instance = null;

	public static DataAccesObject getInstance() {
		if(instance==null) {
			instance = new DataAccesObject();
		} return instance;
	}
	
	/*
	 * REPOSITORY CONTROL
	 */
	private DBCollection col = null;
	private PriorityQueue<Patient> que = null;
	
	public DBCollection getCol() {
		return col;
	}
	
	public void setCol(DBCollection col) {
		this.col = col;
	}
	
	public PriorityQueue<Patient> getQue() {
		return que;
	}

	public void setQue(PriorityQueue<Patient> que) {
		this.que = que;
	}

	/**
	 * Returns a patient object instantiated with data from  Mongo Document
	 */
	@Override
	public Patient documentToObject(DBObject document) {
		Patient patient = new Patient();

		patient.setId(document.get("_id").toString());
		patient.setFirstName(document.get("first_name").toString());
		patient.setLastName(document.get("last_name").toString());
		patient.setAddress(document.get("address").toString());
		patient.setDateOfBirth(document.get("DoB").toString());
		patient.setTelephone(document.get("phone").toString());
		patient.setPatientLog(document.get("patient_log").toString());
		patient.setPrescription(document.get("prescription").toString());
		patient.setPrescriptionReason(document.get("prescription_reason").toString());
		patient.setSignature(document.get("signature").toString());
		
		return patient;
	}

	@Override
	public DBObject objectToDocument(Patient patient) {
		DBObject document = new BasicDBObject();

		document.put("first_name", patient.getFirstName());
		document.put("last_name", patient.getLastName());
		document.put("address", patient.getAddress());
		document.put("DoB", patient.getDateOfBirth());
		document.put("phone", patient.getTelephone());
		document.put("patient_log", patient.getPatientLog());
		document.put("prescription", patient.getPrescription());
		document.put("signature", patient.getSignature());


		return document;
	}

	/*
	 * CRUD FUNCTIONALITY
	 * @see com.silberio.control.DataAccesObjectImpl#inputPatient()
	 */
	Patient patient = new Patient();
	
	//implement all these methods
	
	/**
	 * Inputs a new patient into the database
	 */
	@Override
	public void inputPatient(DBObject patient) {
		col.insert(patient);
		System.out.println("Patient " +patient.get("last_name") +" inserted");
	}

	/**
	 * Retrieves the first patient on the queue
	 */
	@Override
	public Patient retrievePatient() {
		patient = que.peek();
		return patient;
	}

	@Override
	public void editPatient(DBObject patient) {
		DBObject id = //get patient id here
				
		//here replace patient from main window where u edit it
		//should be something like: findOneAndReplace with the new patient thing
		//this could receive the new patient and parse the whole thing
		col.update(query, update)
		
		System.out.println("edit operational");
	}

	@Override
	public Patient removePatient() {
		System.out.println("remove operational");
		return null;
	}

	
	/*
	 * GETTERS & SETTERS
	 */
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
