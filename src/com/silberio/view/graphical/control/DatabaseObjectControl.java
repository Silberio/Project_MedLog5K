package com.silberio.view.graphical.control;

import java.util.Iterator;

import org.bson.Document;

import com.silberio.controller.Logging;
import com.silberio.model.PatientObject;

public class DatabaseObjectControl extends Logging {
	
	private PatientObject patient = null;
	private Document document = null;
	private Document newDocument = null;
	private Iterator<Document> iterator = null;

	@Override
	public void createLoggingObject() {
		String title = "file_" + patient.getLastName() + patient.getFirstName();

		document = new Document("title", title)
				.append("first_name", patient.getFirstName())
				.append("last_name", patient.getLastName())
				.append("address", patient.getAddress())
				.append("DoB", patient.getDateOfBirth())
				.append("phone", patient.getTelephone())
				.append("patient_log", patient.getPatientLog())
				.append("prescription", patient.getPrescription())
				.append("prescription_reason", patient.getPrescriptionReason())
				.append("signature", patient.getSignedBy());		
	}

	@Override
	public void objectToDocument() {
		String title = "file_" + patient.getLastName() + patient.getFirstName();
		
		newDocument = new Document("title", title)
				.append("first_name", patient.getFirstName())
				.append("last_name", patient.getLastName())
				.append("address", patient.getAddress())
				.append("DoB", patient.getDateOfBirth())
				.append("phone", patient.getTelephone())
				.append("patient_log", patient.getPatientLog())
				.append("prescription", patient.getPrescription())
				.append("prescription_reason", patient.getPrescriptionReason())
				.append("signature", patient.getSignedBy());
	}

	@Override
	public void documentToObject() {
		while(iterator.hasNext()) {
			this.document = iterator.next();
			
			this.patient.setFirstName(document.getString("first_name"));
			this.patient.setLastName(document.getString("last_name"));
			this.patient.setAddress(document.getString("address"));
			this.patient.setDateOfBirth(document.getString("DoB"));
			this.patient.setTelephone(document.getString("phone"));
			this.patient.setPatientLog(document.getString("patient_log"));
			this.patient.setPrescription(document.getString("prescription"));
			this.patient.setPrescriptionReason(document.getString("prescription_reason"));
			this.patient.setSignedBy(document.getString("signature"));
		}
	}
	
	/*
	 * GETTERS AND SETTERS
	 */

	public PatientObject getPatient() {
		return patient;
	}

	public void setPatient(PatientObject patient) {
		this.patient = patient;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Iterator<Document> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<Document> iterator) {
		this.iterator = iterator;
	}
	
	

}
