package com.silberio.view.graphical.model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OutputPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * SINGLETON INSTANTIATION
	 */
	private static OutputPanel instance = null;

	public static OutputPanel getInstance() {
		if (instance == null) {
			instance = new OutputPanel();
		}
		return instance;
	}
	/*
	 * END SINGLETON INSTANTIATION
	 */
	private final MedLogTan MLTAN = new MedLogTan();
	private JLabel label;
	private JTextArea fnameField, lnameField, addressField, dateOfBirthField, phoneField, logField, prescriptionField, prescriptionReasonField, signatureField;
	private JButton retrieveBtn = new JButton("Retrieve Patient");
	private JButton outputBtn = new JButton("Remove Patient");
	private JButton editBtn = new JButton("Edit File");
	private JButton updateBtn = new JButton("Update");
	
	public OutputPanel() {
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		this.setBackground(MLTAN);
		this.setLayout(grid);
		this.setBorder(BorderFactory.createEmptyBorder(1, 2, 2, 2));
		this.add(Box.createRigidArea(new Dimension(0, 5)));

		gbc.insets = new Insets(0, 5, 4, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(outputLabel("Name: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(fnameField = new JTextArea(1,5), gbc);
		this.fnameField.setEditable(false);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(lnameField = new JTextArea(1,10), gbc);
		this.lnameField.setEditable(false);
		
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(outputLabel("Address: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(addressField = new JTextArea(1,20), gbc);
		this.addressField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(outputLabel("D.o.B.: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(dateOfBirthField = new JTextArea(1,20), gbc);
		this.dateOfBirthField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(outputLabel("Telephone: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(phoneField = new JTextArea(1,20), gbc);
		this.phoneField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		this.add(outputLabel("Patient Log: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(logField = new JTextArea(8,10), gbc);
		this.logField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 11;
		this.add(outputLabel("Prescription: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 12;
		this.add(prescriptionField = new JTextArea(1,5), gbc);
		this.prescriptionField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 13;
		this.add(outputLabel("Prescription Reason: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 14;
		this.add(prescriptionReasonField = new JTextArea(4,5), gbc);
		this.prescriptionReasonField.setEditable(false);
	
		
		gbc.gridx = 0;
		gbc.gridy = 15;
		this.add(retrieveBtn, gbc);	
		
		gbc.gridx = 0;
		gbc.gridy = 16;
		this.add(outputBtn, gbc);
		outputBtn.setEnabled(false);
		
		gbc.gridx = 1;
		gbc.gridy = 15;
		this.add(editBtn, gbc);
		editBtn.setEnabled(false);
		
		gbc.gridx = 1;
		gbc.gridy = 16;
		this.add(updateBtn, gbc);
		updateBtn.setEnabled(false);
	}	
	

	private JLabel outputLabel(String fieldDisplayName) {
		label = new JLabel(fieldDisplayName);
		
		return label;
	}

	/*
	 * GETTERS AND SETTERS
	 */

	public JTextArea getFnameField() {
		return fnameField;
	}


	public void setFnameField(JTextArea fnameField) {
		this.fnameField = fnameField;
	}


	public JTextArea getLnameField() {
		return lnameField;
	}


	public void setLnameField(JTextArea lnameField) {
		this.lnameField = lnameField;
	}

	
	public JTextArea getAddressField() {
		return addressField;
	}

	public void setAddressField(JTextArea addressField) {
		this.addressField = addressField;
	}


	public JTextArea getDateOfBirthField() {
		return dateOfBirthField;
	}


	public void setDateOfBirthField(JTextArea doateOfBirthField) {
		this.dateOfBirthField = doateOfBirthField;
	}


	public JTextArea getPhoneField() {
		return phoneField;
	}


	public void setPhoneField(JTextArea phoneField) {
		this.phoneField = phoneField;
	}


	public JTextArea getLogField() {
		return logField;
	}


	public void setLogField(JTextArea logField) {
		this.logField = logField;
	}


	public JTextArea getPrescriptionField() {
		return prescriptionField;
	}


	public void setPrescriptionField(JTextArea prescriptionField) {
		this.prescriptionField = prescriptionField;
	}
	

	public JTextArea getPrescriptionReasonField() {
		return prescriptionReasonField;
	}


	public void setPrescriptionReasonField(JTextArea prescriptionReasonField) {
		this.prescriptionReasonField = prescriptionReasonField;
	}


	public JTextArea getSignatureField() {
		return signatureField;
	}


	public void setSignatureField(JTextArea signatureField) {
		this.signatureField = signatureField;
	}


	public JButton getOutputBtn() {
		return outputBtn;
	}


	public void setOutputBtn(JButton outputBtn) {
		this.outputBtn = outputBtn;
	}


	public JButton getEditBtn() {
		return editBtn;
	}


	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
	}


	public JButton getUpdateBtn() {
		return updateBtn;
	}


	public void setUpdateBtn(JButton updateInfo) {
		this.updateBtn = updateInfo;
	}


	public JButton getRetrieveBtn() {
		return retrieveBtn;
	}


	public void setRetrieveBtn(JButton retrieveBtn) {
		this.retrieveBtn = retrieveBtn;
	}


	
	
	
}
