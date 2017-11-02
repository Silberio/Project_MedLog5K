package com.silberio.view.graphical.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
	
	/**
	 * Button listener to display a patient toString in the GUI list
	 * @param btn
	 * @param listPanel
	 */
	public void insertPatientToList(JButton btn, ListPanel listPanel) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				instantiatePatientObjectFromGUIInfo();
				setListPanel(listPanel);
				displayPatientOnList();
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
	
	public void displayPatientsFromDatabase() {
		
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

	

	}
