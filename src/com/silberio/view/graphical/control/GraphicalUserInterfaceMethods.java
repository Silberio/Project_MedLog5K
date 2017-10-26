package com.silberio.view.graphical.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.silberio.controller.PatientLogging;
import com.silberio.model.PatientObject;
import com.silberio.model.PatientQueue;
import com.silberio.view.graphical.model.InputPanel;
import com.silberio.view.graphical.model.ListPanel;
import com.silberio.view.graphical.model.OutputPanel;
import com.silberio.view.graphical.model.SearchPanel;

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
	private PatientQueue patientQueue;

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
	
	public void initQueue() {
		patientQueue = new PatientQueue();
		
	}
	
	/**
	 * listener for button in InputPanel
	 * @param btn
	 * @param inputPanel
	 */
	public void inputButtonListener(JButton btn, InputPanel inputPanel, ListPanel listPanel) {
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
				
				//Insert everything into its specific place
				patLog.setCollection(collection);
				patLog.setPatient(patient);
				patLog.objectToDocument();
				patLog.insertDocument();
				
				patientQueue.insertPatientIntoQueue(patient);
				
				listPanel.addPatientToList(patLog.getPatient().toString());
				listPanel.insertPatientToInternalList(patient);
				
				//clear GUI
				inputPanel.getfNameField().setText("");
				inputPanel.getlNameField().setText("");
				inputPanel.getDobField().setText("");
				inputPanel.getAddressField().setText("");
				inputPanel.getPhoneField().setText("");
				inputPanel.getLogArea().setText("");
				inputPanel.getPrescription().setText("");
				inputPanel.getPrescriptionReason().setText("");
				inputPanel.getSignature().setText("");
			}

		});
	}
	
	/**
	 * Listener for outputPanel button to head patient file from list
	 * @param btn
	 * @param outputPanel
	 * @param listPanel
	 */
	public void outputButtonistener(JButton btn, OutputPanel outputPanel, ListPanel listPanel) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				patient = patientQueue.getFirstPrioPatient();
				outputPanel.displayInfo(
						patient.getLastName(), 
						patient.getAddress(), 
						patient.getDateOfBirth(), 
						patient.getTelephone(),
						patient.getPatientLog(),
						patient.getPrescription(),
						patient.getSignedBy());
				
				listPanel.removePatientFromList();

			}
		});
	}
	
	/**
	 * Loads the patientlist from MongoDB object into patient list
	 * @param listPanel
	 * @param collection
	 */
	public void loadPatientList(ListPanel listPanel, MongoCollection<Document> collection) {
		MongoCursor<Document> cursor = collection.find().iterator();
		BasicDBObject object = new BasicDBObject();
		String str;
		
		while(cursor.hasNext()) {
			str = (String) cursor.next().get("signature");
			
			listPanel.addPatientToList(str);
		}
	}
	
	/**
	 * method for searching in the patient list
	 * @param searchPanel
	 */
	public void searchPatientFile(SearchPanel searchPanel, ListPanel listPanel) {
		String category = (String) searchPanel.getSearchCategory().getSelectedItem();
		
		//Last name", "First name", "Doctor", "Birth date
		switch(category) {
		case "Last name":
			category = "lastName";
			break;
		case "First name":
			category = "firstName";
			break;
		case "Doctor":
			category = "signature";
			break;
		case "Birth date":
			category = "DoB";
			break;
		}
		
		CharSequence searchTerm = searchPanel.getSearchBar().getText().toLowerCase();
		 
		listPanel.searchElement(searchTerm);
		}
	
	/**
	 * click handler for search button
	 * @param btn
	 * @param searchPanel
	 */
	public void searchButtonClickHandler(JButton btn, SearchPanel searchPanel, ListPanel listPanel) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchPatientFile(searchPanel, listPanel);				
			}
		});
	}

	public void editButtonClickHandler(JButton btn, OutputPanel outputPanel) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				outputPanel.editInfo();
				//Sets info sent from GUI into a patient object
				
						
				
				//Insert everything into its specific place
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

	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public PatientQueue getPatientQueue() {
		return patientQueue;
	}

	public void setPatientQueue(PatientQueue patientQueue) {
		this.patientQueue = patientQueue;
	}
	
	

}
