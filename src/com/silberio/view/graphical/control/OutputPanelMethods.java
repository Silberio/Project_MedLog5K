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
	private DatabaseConnection connection = null;

	/**
	 * Listener for outputPanel button to head patient file from list
	 * 
	 * @param btn
	 * @param outputPanel
	 * @param listPanel
	 */
	public void outputButtonistener(JButton btn, OutputPanel outputPanel) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				documentToObject();
				setTextToOutputFields(outputPanel);
			}
		});
	}
	
	private void setTextToOutputFields(OutputPanel outputPanel) {
		outputPanel.getNameField().setText(this.patient.getLastName() + ", " + this.patient.getFirstName());

	}
	
	/*
	 * INHERITED METHODS
	 */

	@Override
	public void createLoggingObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectToDocument() {
		// TODO Auto-generated method stub
		
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
			this.patient.setPrescriptionReason(document.getString("prescription_reson"));
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
