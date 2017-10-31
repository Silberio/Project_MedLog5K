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
import com.silberio.view.graphical.model.InputPanel;

/**
 * This class contains all the methods used in Input Panel.
 * <p>
 * Methods here export a single Patient Object to be manipulated by logging
 * system
 * </p>
 * 
 * @author silberio_stalone
 *
 */
public class InputPanelMethods extends Logging {

	/*
	 * SINGLETON INSTANTIATION
	 */
	private static InputPanelMethods instance = null;

	public static InputPanelMethods getInstance() {
		if (instance == null) {
			instance = new InputPanelMethods();
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

	/*
	 * ACTION LISTENERS FOR INPUT BUTTONS
	 */

	/**
	 * Listener for input info button on the GUI frame
	 * 
	 * <p>
	 * So far it initializes the patient object
	 * </p>
	 * 
	 * @param btn
	 *            the target button to append the listener to
	 * @param inputPanel
	 *            the panel in which the button is
	 */
	public void inputButtonListener(JButton btn, InputPanel inputPanel) {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/*
				 * this gets all the info from the GUI and inserts into each parameter of the
				 * instantiatePatientObjectFromGUIInfo() method
				 */
				instantiatePatientObjectFromGUIInfo(inputPanel);
				
				//create a document from patient object
				createLoggingObject();
				
				//insert document object to database
				insertDocument(document);

				// clear GUI
				clearGUIFields(inputPanel);
			}
		});
	}


	/**
	 * Instantiates a new patient object with input information
	 * 
	 */
	private void instantiatePatientObjectFromGUIInfo(InputPanel inputPanel) {

		patient = new PatientObject();
		patient.setFirstName(inputPanel.getfNameField().getText());
		patient.setLastName(inputPanel.getlNameField().getText());
		patient.setAddress(inputPanel.getAddressField().getText());
		patient.setDateOfBirth(inputPanel.getDobField().getText());
		patient.setPatientLog(inputPanel.getLogArea().getText());
		patient.setPrescription(inputPanel.getPrescription().getText());
		patient.setPrescriptionReason(inputPanel.getPrescriptionReason().getText());
		patient.setSignedBy(inputPanel.getSignature().getText());
		// Patient Object is instantiated
	}
	
	/**
	 * Sets text to JTextFields on the input GUI to "" (empty string)
	 * 
	 * @param inputPanel The target input panel
	 */
	private void clearGUIFields(InputPanel inputPanel) {
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

	/**
	 * inserts a document into a collection
	 * 
	 * @param collection
	 * @param document
	 */
	public void insertDocument(Document document) {

		collection.insertOne(document);
	}
	
	/*
	 * INHERITED METHODS
	 */
	
	/**
	 * Inititates a mongodb document with input information
	 */
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void documentToObject() {
		Iterator<Document> iterator = connection.getCollection().find().iterator();
		
		while(iterator.hasNext()) {
			this.document = iterator.next();
			
			this.patient.setFirstName(document.getString("first_name"));
			this.patient.setLastName(document.getString("last_name"));
			this.patient.setAddress(document.getString("address"));
			this.patient.setDateOfBirth(document.getString("DoB"));
			this.patient.setTelephone(document.getString("phone"));
			this.patient.setPatientLog(document.getString("patient_log"));
			this.patient.setPrescription(document.getString("prescription"));
			this.patient.setPrescriptionReason(document.getString("presc_reson"));
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
