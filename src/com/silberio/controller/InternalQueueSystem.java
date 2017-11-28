package com.silberio.controller;

import java.util.Iterator;
import java.util.PriorityQueue;

import org.bson.Document;

import com.silberio.model.PatientObject;

public class InternalQueueSystem {

	/*
	 * SINGLETON INSTANTIATION
	 */
	
	public static InternalQueueSystem instance = null;
	
	public static InternalQueueSystem getInstance() {
		if(instance==null) {
			instance = new InternalQueueSystem();
		} return instance;
	}
	
	/*
	 * END SINGLETON INSTANTIATION
	 */
	
	private PriorityQueue<PatientObject> patientQueue = new PriorityQueue<>();
	private PatientObject patient = null;
	private Document document = null;
	private Iterator<Document> iterator = null;
	
	public void loadQueue() {
		while(iterator.hasNext()) {
			this.document = iterator.next();
			patient = new PatientObject();
			
			this.patient.setId(document.getObjectId("_id"));
			this.patient.setFirstName(document.getString("first_name"));
			this.patient.setLastName(document.getString("last_name"));
			this.patient.setAddress(document.getString("address"));
			this.patient.setDateOfBirth(document.getString("DoB"));
			this.patient.setTelephone(document.getString("phone"));
			this.patient.setPatientLog(document.getString("patient_log"));
			this.patient.setPrescription(document.getString("prescription"));
			this.patient.setPrescriptionReason(document.getString("prescription_reason"));
			this.patient.setSignedBy(document.getString("signature"));
			
			patientQueue.offer(patient);			
		}
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public PriorityQueue<PatientObject> getPatientQueue() {
		return patientQueue;
	}
	public void setPatientQueue(PriorityQueue<PatientObject> patientQueue) {
		this.patientQueue = patientQueue;
	}

	public PatientObject getPatient() {
		return patient;
	}

	public void setPatient(PatientObject patient) {
		this.patient = patient;
	}

	public Iterator<Document> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<Document> iterator) {
		this.iterator = iterator;
	}
}
