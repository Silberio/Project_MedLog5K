package com.silberio.view.graphical.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.silberio.controller.DatabaseConnection;
import com.silberio.controller.Logging;
import com.silberio.model.PatientObject;
import com.silberio.view.graphical.model.OutputPanel;

public class OutputPanelMethods extends Logging {

	/*
	 * SINGLETON INSTANTIATION
	 */
	private static OutputPanelMethods instance = null;

	public static OutputPanelMethods getInstance() {
		if (instance == null) {
			instance = new OutputPanelMethods();
		}
		return instance;
	}
	/*
	 * END SINGLETON INSTANTIATION
	 */

	private PatientObject patient = null;
	private MongoCollection<Document> collection = null;
	private Document document = null;
	private Document newDocument = null;
	private DatabaseConnection connection = null;

	/*
	 * BUTTON LISTENERS
	 */
	
	/**
	 * Listener for Retrieving patient file button
	 * 
	 */
	public void retrieveButtonListener(JButton btn, OutputPanel outputPanel) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				documentToObject();
				setTextToOutputFields(outputPanel);
			}
		});
	}
	
	/**
	 * Listener for outputPanel button to remove selected patient
	 * 
	 * @param btn
	 * @param outputPanel
	 * @param listPanel
	 */
	public void outputButtonListener(JButton btn, OutputPanel outputPanel) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
	
	/**
	 * Listener for the output panel "Edit" button
	 * @param btn
	 * @param outputPanel
	 */
	public void editButtonListener(JButton btn, OutputPanel outputPanel) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openFieldsForEdit(outputPanel);
			}
		});
	}
	
	/**
	 * listener for "update" button
	 * @param btn
	 * @param outputPanel
	 */
	public void updateButtonListener(JButton btn, OutputPanel outputPanel) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveEditedInfo(outputPanel);
				lockEditFields(outputPanel);
				objectToDocument();
				updateDocument();			
				}
		});
	}
	/*
	 * METHODS
	 */
	
	private void setTextToOutputFields(OutputPanel outputPanel) {
		outputPanel.getNameField().setText(this.patient.getLastName() + ", " + this.patient.getFirstName());
		outputPanel.getAddressField().setText(this.patient.getAddress());
		outputPanel.getDateOfBirthField().setText(this.patient.getDateOfBirth());
		outputPanel.getPhoneField().setText(this.patient.getTelephone());
		outputPanel.getLogField().setText(this.patient.getPatientLog());
		outputPanel.getPrescriptionField().setText(this.patient.getPrescription() + "\nReason: " + this.patient.getPrescriptionReason());
	}
	
	
	private void openFieldsForEdit(OutputPanel outputPanel) {

		outputPanel.getAddressField().setEditable(true);
		outputPanel.getDateOfBirthField().setEditable(true);
		outputPanel.getPhoneField().setEditable(true);
		outputPanel.getLogField().setEditable(true);
		outputPanel.getPrescriptionField().setEditable(true);
	}
	
	private void lockEditFields(OutputPanel outputPanel) {
		outputPanel.getAddressField().setEditable(false);
		outputPanel.getDateOfBirthField().setEditable(false);
		outputPanel.getPhoneField().setEditable(false);
		outputPanel.getLogField().setEditable(false);
		outputPanel.getPrescriptionField().setEditable(false);
	}
	
	private void saveEditedInfo(OutputPanel outputPanel) {
		patient = new PatientObject();
		
		patient.setAddress(outputPanel.getAddressField().getText());
		patient.setDateOfBirth(outputPanel.getDateOfBirthField().getText());
		patient.setTelephone(outputPanel.getPhoneField().getText());
		patient.setPatientLog(outputPanel.getLogField().getText());
		patient.setPrescription(outputPanel.getPrescriptionField().getText());
	}
	
	/**
	 * updates a document in a collection
	 * 
	 * @param collection
	 * @param document
	 */
	public void updateDocument() {

		collection.replaceOne(document, newDocument);
	}
	
	
	
	/*
	 * INHERITED METHODS
	 */

	@Override
	public void createLoggingObject() {
		
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
		Iterator<Document> iterator = connection.getCollection().find().iterator();
		
		while(iterator.hasNext()) {
			this.document = iterator.next();
			patient = new PatientObject();
			
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
	 * GETERS AND SETTERS
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

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public DatabaseConnection getConnection() {
		return connection;
	}

	public void setConnection(DatabaseConnection connection) {
		this.connection = connection;
	}


	
	
	

}
