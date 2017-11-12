package com.silberio.view.graphical.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.PriorityQueue;

import javax.swing.JButton;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.silberio.controller.DatabaseConnection;
import com.silberio.model.PatientObject;
import com.silberio.view.graphical.model.InputPanel;
import com.silberio.view.graphical.model.ListPanel;

public class ListPanelMethods {
	/*
	 * SINGLETON INSTANTIATION
	 */
	private static ListPanelMethods instance = null;
	
	public static ListPanelMethods getInstance() {
		if(instance==null) {
			instance = new ListPanelMethods();
		}	return instance;
	}
	/*
	 * END SINGLETON INSTANTIATION
	 */
	
	private PatientObject patient =  new PatientObject();
	private ListPanel listPanel = new ListPanel();
	private InputPanel inputPanel = new InputPanel();
	
	private MongoCollection<Document> collection = null;
	private Document document = null;
	private DatabaseConnection connection = null;
	
	private PriorityQueue<PatientObject> queue = new PriorityQueue<>();
	private Iterator<Document> iterator = null;
	
	/**
	 * Button listener to display a patient toString in the GUI list
	 * @param btn
	 * @param listPanel
	 */
	public void insertPatientToList(JButton btn, ListPanel listPanel) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setListPanel(listPanel);
				instantiatePatientObjectFromGUIInfo();
				System.out.println(queue.peek());
				//displayPatientOnList();
			}
		});
	}
	
	/**
	 * displays input patient file in the list
	 */
	private void displayPatientOnList() {
		listPanel.getModel().addElement(patient.toString());
	}

	/**
	 * Instantiates a new patient object with input information
	 * 
	 */
	private void instantiatePatientObjectFromGUIInfo() {

		patient = new PatientObject();
		patient.setFirstName(inputPanel.getfNameField().getText());
		patient.setLastName(inputPanel.getlNameField().getText());
		patient.setAddress(inputPanel.getAddressField().getText());
		patient.setDateOfBirth(inputPanel.getDobField().getText());
		patient.setTelephone(inputPanel.getPhoneField().getText());
		patient.setPatientLog(inputPanel.getLogArea().getText());
		patient.setPrescription(inputPanel.getPrescription().getText());
		patient.setPrescriptionReason(inputPanel.getPrescriptionReason().getText());
		patient.setSignedBy(inputPanel.getSignature().getText());
		// Patient Object is instantiated
	}
	
	private Iterator<Document> documentIterator() {
		iterator = connection.getCollection().find().iterator();

		return iterator;
	}
	
	
	public void displayPatientsFromDatabase() {
		
		while(documentIterator().hasNext()) {
			this.document = documentIterator().next();
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

	/**
	 * initiates the internal queue with patient objects
	 */
	public void loadPatientQueue() {
		
		while(documentIterator().hasNext()) {
			this.document = documentIterator().next();
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
			
			queue.add(patient);
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


	public ListPanel getListPanel() {
		return listPanel;
	}


	public void setListPanel(ListPanel listPanel) {
		this.listPanel = listPanel;
	}

	public InputPanel getInputPanel() {
		return inputPanel;
	}

	public void setInputPanel(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	public DatabaseConnection getConnection() {
		return connection;
	}

	public void setConnection(DatabaseConnection connection) {
		this.connection = connection;
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

	}
