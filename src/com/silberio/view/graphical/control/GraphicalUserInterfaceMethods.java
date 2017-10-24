package com.silberio.view.graphical.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.silberio.controller.PatientLogging;
import com.silberio.model.PatientObject;
import com.silberio.view.graphical.model.InputPanel;

public class GraphicalUserInterfaceMethods {

	private static GraphicalUserInterfaceMethods instance = null;

	public static GraphicalUserInterfaceMethods getInstance() {
		if (instance == null) {
			instance = new GraphicalUserInterfaceMethods();
		}
		return instance;
	}
	
	private PatientLogging patLog = PatientLogging.getInstance();
	private PatientObject patient;
	private MongoCollection<Document> collection;
	
	private Boolean documentReady = false;
	
	/**
	 * sets info from GUI into GUI Methods string variables
	 * @param fnameul 
	 * @param lname
	 * @param dob
	 * @param address
	 * @param phone
	 * @param log
	 * @param prescription
	 * @param reason
	 * @param signature
	 */
	public void setInfoFromGUI(String fname, String lname, String dob, String address, String phone, String log,
			String prescription, String reason, String signature) {
		
		patient = new PatientObject(fname, lname, address, dob, phone);
		patient.setPatientLog(log);
		patient.setPrescription(prescription);
		patient.setReason(reason);
		patient.doctorSignature(signature);
		
		}
	
	/**
	 * listener for button in InputPanel
	 * @param btn
	 * @param inputPanel
	 */
	public void inputButtonListener(JButton btn, InputPanel inputPanel) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Sets info sent from GUI into a patient object
				setInfoFromGUI(
						inputPanel.getfNameField().getText(), 
						inputPanel.getlNameField().getText(),
						inputPanel.getDobField().getText(), 
						inputPanel.getAddressField().getText(),
						inputPanel.getPhoneField().getText(), 
						inputPanel.getLogArea().getText(),
						inputPanel.getPrescription().getText(), 
						inputPanel.getPrescriptionReason().getText(),
						inputPanel.getSignature().getText());
				
				patLog.setCollection(collection);
				patLog.setPatient(patient);
				patLog.objectToDocument();
				patLog.insertDocument();
			}

		});
	}




	/*
	 * 
	 * GETTERS & SETTERS
	 * 
	 */
	public PatientObject getPatient() {
		return patient;
	}

	public void setPatient(PatientObject patient) {
		this.patient = patient;
	}

	public Boolean getDocumentReady() {
		return documentReady;
	}

	public void setDocumentReady(Boolean documentReady) {
		this.documentReady = documentReady;
	}

	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

}
