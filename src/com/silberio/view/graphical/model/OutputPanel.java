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

	private final MedLogTan MLTAN = new MedLogTan();
	private JLabel label;
	private JTextField outputField;
	private JTextArea nameField, addressField, dobField, phoneField, logField, prescriptionField, signatureField;
	private JButton outputBtn = new JButton("Remove Patient");
	private JButton editBtn = new JButton("Edit File");
	private JButton updateInfo = new JButton("Update");
	
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
		this.add(nameField = new JTextArea(1,20), gbc);
		this.nameField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(outputLabel("Address: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(addressField = new JTextArea(1,20), gbc);
		this.addressField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(outputLabel("D.o.B.: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(dobField = new JTextArea(1,20), gbc);
		this.dobField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(outputLabel("Telephone: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(phoneField = new JTextArea(1,20), gbc);
		this.phoneField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(outputLabel("Patient Log: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		this.add(logField = new JTextArea(10,10), gbc);
		this.logField.setEditable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(outputLabel("Prescription: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 11;
		this.add(prescriptionField = new JTextArea(5,5), gbc);
		this.prescriptionField.setEditable(false);
	
		
		gbc.gridx = 0;
		gbc.gridy = 12;
		this.add(outputBtn, gbc);	
		
		gbc.gridx = 1;
		gbc.gridy = 12;
		this.add(editBtn, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 13;
		this.add(updateInfo, gbc);
	}	
	

	private JLabel outputLabel(String fieldDisplayName) {
		label = new JLabel(fieldDisplayName);
		
		return label;
	}
	
	public void displayInfo(String name, String address, String dob, String phone, String log, String prescription, String signature) {
		nameField.setText(name);
		addressField.setText(address);
		dobField.setText(dob);
		phoneField.setText(phone);
		logField.setText(log);
		prescriptionField.setText(prescription);
		signatureField.setText(signature);
	}
	
	public void editInfo() {
		nameField.setEditable(true);
		addressField.setEditable(true);
		dobField.setEditable(true);
		phoneField.setEditable(true);
		logField.setEditable(true);
		prescriptionField.setEditable(true);
		signatureField.setEditable(true);
	}

	public JTextField getOutputField() {
		return outputField;
	}

	public void setOutputField(JTextField outputField) {
		this.outputField = outputField;
	}

	public JTextArea getNameField() {
		return nameField;
	}

	public void setNameField(JTextArea nameField) {
		this.nameField = nameField;
	}

	public JTextArea getAddressField() {
		return addressField;
	}

	public void setAddressField(JTextArea addressField) {
		this.addressField = addressField;
	}

	public JTextArea getDobField() {
		return dobField;
	}

	public void setDobField(JTextArea dobField) {
		this.dobField = dobField;
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
	
	
	
}
