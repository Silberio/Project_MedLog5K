package com.silberio.control;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.silberio.model.Patient;

public class DataAccesObject implements DataAccesObjectImpl {
	private static DataAccesObject instance = null;

	public static DataAccesObject getInstance() {
		if(instance==null) {
			instance = new DataAccesObject();
		} return instance;
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

}
