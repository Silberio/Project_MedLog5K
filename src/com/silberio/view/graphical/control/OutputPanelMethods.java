package com.silberio.view.graphical.control;

import java.util.Iterator;
import java.util.PriorityQueue;

import javax.swing.JButton;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.silberio.controller.DatabaseConnection;
import com.silberio.controller.Logging;
import com.silberio.model.PatientObject;
import com.silberio.view.graphical.model.ListPanel;
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
	private OutputPanel outputPanel = null;
	private ListPanel listPanel = null; 
	private Iterator<Document> iterator = null;
	private PriorityQueue<PatientObject> queue;

	/*
	 * BUTTON LISTENERS
	 */
	
	/**
	 * Listener for Retrieving patient file button
	 * 
	 * 
	 */
	public void retrieveButtonListener(JButton btn) {
		btn.addActionListener(e -> retrievePatient());
	}
	
	/**
	 * Listener for outputPanel button to remove selected patient
	 * 
	 * @param btn
	 * @param outputPanel
	 * @param listPanel
	 */
	public void outputButtonListener(JButton btn) {
		
		btn.addActionListener(e -> removePatient());
		
	}
	

	
	/**
	 * Listener for the output panel "Edit" button
	 * @param btn
	 * @param outputPanel
	 */
	public void editButtonListener(JButton btn) {
		btn.addActionListener(e -> editPatient());
	}
	
	/**
	 * listener for "update" button
	 * @param btn
	 * @param outputPanel
	 */
	public void updateButtonListener(JButton btn) {
		btn.addActionListener(e -> updatePatient());
	}
	/*
	 * ACTION LISTENER METHODS 
	 */
	private void retrievePatient() {
		this.patient = queue.peek();
		
		setTextToOutputFields();
		
		outputPanel.getEditBtn().setEnabled(true);
		outputPanel.getUpdateBtn().setEnabled(true);
		outputPanel.getOutputBtn().setEnabled(true);
		
		}
	
	private void removePatient() {
		clearOutputFields();
		removePatientFromDB();
		queue.poll();
		outputPanel.getOutputBtn().setEnabled(false);
		outputPanel.getUpdateBtn().setEnabled(false);
		outputPanel.getEditBtn().setEnabled(false);
	}
	
	private void editPatient() {
		openFieldsForEdit();
		
		outputPanel.getEditBtn().setEnabled(false);
	}
	
	private void updatePatient() {
		saveEditedInfo();
		lockEditFields();
		objectToDocument();
		updateDocument();
		updateList();
		
		outputPanel.getUpdateBtn().setEnabled(false);
	
	}
	/*
	 * METHODS
	 */
	
	private void updateList() {
		
		if(listPanel.getModel().contains(patient)) {
			
		}
		listPanel.getModel().addElement(patient.toString());

	}
	
	/**
	 * Fills the output text fields with data from a patient object
	 */
	private void setTextToOutputFields() {
		
		outputPanel.getFnameField().setText(this.patient.getFirstName());
		outputPanel.getLnameField().setText(this.patient.getLastName());
		outputPanel.getAddressField().setText(this.patient.getAddress());
		outputPanel.getDateOfBirthField().setText(this.patient.getDateOfBirth());
		outputPanel.getPhoneField().setText(this.patient.getTelephone());
		outputPanel.getLogField().setText(this.patient.getPatientLog());
		outputPanel.getPrescriptionField().setText(this.patient.getPrescription());
		outputPanel.getPrescriptionReasonField().setText(this.patient.getPrescriptionReason());
	}
	
	
	private void openFieldsForEdit() {
		outputPanel.getFnameField().setEditable(true);
		outputPanel.getLnameField().setEditable(true);
		outputPanel.getAddressField().setEditable(true);
		outputPanel.getDateOfBirthField().setEditable(true);
		outputPanel.getPhoneField().setEditable(true);
		outputPanel.getLogField().setEditable(true);
		outputPanel.getPrescriptionField().setEditable(true);
		outputPanel.getPrescriptionReasonField().setEditable(true);
	}
	
	private void lockEditFields() {
		outputPanel.getFnameField().setEditable(false);
		outputPanel.getLnameField().setEditable(false);
		outputPanel.getAddressField().setEditable(false);
		outputPanel.getDateOfBirthField().setEditable(false);
		outputPanel.getPhoneField().setEditable(false);
		outputPanel.getLogField().setEditable(false);
		outputPanel.getPrescriptionField().setEditable(false);
		outputPanel.getPrescriptionReasonField().setEditable(false);
	}
	
	private void saveEditedInfo() {
		patient = new PatientObject();
		
		patient.setFirstName(outputPanel.getFnameField().getText());
		patient.setLastName(outputPanel.getLnameField().getText());
		patient.setAddress(outputPanel.getAddressField().getText());
		patient.setDateOfBirth(outputPanel.getDateOfBirthField().getText());
		patient.setTelephone(outputPanel.getPhoneField().getText());
		patient.setPatientLog(outputPanel.getLogField().getText());
		patient.setPrescription(outputPanel.getPrescriptionField().getText());
		patient.setPrescriptionReason(outputPanel.getPrescriptionReasonField().getText());

	}

	private void clearOutputFields() {
		outputPanel.getFnameField().setText("");
		outputPanel.getLnameField().setText("");
		outputPanel.getAddressField().setText("");
		outputPanel.getDateOfBirthField().setText("");
		outputPanel.getPhoneField().setText("");
		outputPanel.getLogField().setText("");
		outputPanel.getPrescriptionField().setText("");
		outputPanel.getPrescriptionReasonField().setText("");
	}
	
	/**
	 * updates a document in a collection
	 * 
	 * @param collection
	 * @param document
	 */
	public void updateDocument() {
		this.patient = queue.peek();

		//Here it finds the patient document by patient ID
		Document query = new Document("_id", patient.getId());
		FindIterable<Document> doc = collection.find(query);
		//Sets newDoc to the document with the queried ID
		Document newDoc = doc.first();
		
		collection.replaceOne(newDoc, document);
	}
	
	public void removePatientFromDB() {
		Document query = new Document("_id", patient.getId());
		FindIterable<Document> doc = collection.find(query);

		collection.findOneAndDelete(doc.first());
	}
	
	/*
	 * INHERITED METHODS
	 */

	/**
	 * Grabs all the data from a document and inserts it into a PatientObject
	 */
	@Override
	public void documentToObject() {		
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
		}
		
	}
	
	@Override
	public void createLoggingObject() {

	}

	@Override
	public void objectToDocument() {
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

	public OutputPanel getOutputPanel() {
		return outputPanel;
	}

	public void setOutputPanel(OutputPanel outputPanel) {
		this.outputPanel = outputPanel;
	}

	public Iterator<Document> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<Document> iterator) {
		this.iterator = iterator;
	}

	public PriorityQueue<PatientObject> getQueue() {
		return queue;
	}

	public void setQueue(PriorityQueue<PatientObject> queue) {
		
		this.queue = queue;
	}

	public ListPanel getListPanel() {
		return listPanel;
	}

	public void setListPanel(ListPanel listPanel) {
		this.listPanel = listPanel;
	}
	
	
}
