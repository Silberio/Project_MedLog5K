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
	 * Returns a patient objct instantiated with data from  Mongo Document
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
		patient.setPrescriptionReason(document.get("prescription").toString());
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
	
	@Override
	public void inputPatient(DBObject patient) {
		col.insert(patient);
		System.out.println("Patient " +patient.get("last_name") +" inserted");
	}

	@Override
	public Patient retrievePatient() {
		return patient;
	}

	@Override
	public Patient editPatient() {
		System.out.println("edit operational");
		return null;
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
