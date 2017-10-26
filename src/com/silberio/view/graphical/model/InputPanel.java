package com.silberio.view.graphical.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InputPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static InputPanel instance = null;

	public static InputPanel getInstance() {
		if (instance == null) {
			instance = new InputPanel();
		}
		return instance;
	}

	private final MedLogTan MLTAN = new MedLogTan();
	
	private InputField fNameField, lNameField, addressField, dobField, phoneField, prescription, signature;
	private JTextArea logArea  = new JTextArea(10, 15); 
	private JTextArea prescriptionReason  = new JTextArea(5, 15);
	private JScrollPane pane = null;
	
	private JLabel label = null;
	
	private JButton inputBtn = new JButton("Input Info");

	/**
	 * JPanel with text fields to fill info for patients.
	 */
	public InputPanel() {
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		this.setBackground(MLTAN);
		this.setLayout(grid);
		this.setBorder(BorderFactory.createEmptyBorder(1, 2, 2, 2));
		this.add(Box.createRigidArea(new Dimension(0, 5)));

		gbc.insets = new Insets(2, 5, 2, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(label = new JLabel("Name: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(fNameField = new InputField("fname"), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(lNameField = new InputField("lname"), gbc);

		gbc.insets.set(10, 5, 2, 10);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(label = new JLabel("Address: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(addressField = new InputField("address"), gbc);
		gbc.insets.set(5, 5, 2, 10);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(label = new JLabel("D.o.B.: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(dobField = new InputField("dob"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(label = new JLabel("Telephone: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(phoneField = new InputField("phone"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(label = new JLabel("Patient Log: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(pane = new JScrollPane(logArea), gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(label = new JLabel("Prescription: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 7;
		this.add(prescription = new InputField("prescription"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(label = new JLabel("Reason for prescription: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 9;
		this.add(pane = new JScrollPane(prescriptionReason), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(label = new JLabel("Doctor Signature: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 10;
		this.add(signature = new InputField("signature"), gbc);
		
		gbc.insets.set(8, 10, 10, 10);
		gbc.weighty = 10;
		gbc.gridx = 1;
		gbc.gridy = 11;
		this.add(inputBtn, gbc);		

	}

	public JButton getInputBtn() {
		return inputBtn;
	}

	public void setInputBtn(JButton inputBtn) {
		this.inputBtn = inputBtn;
	}


	/*
	 * 
	 * GETTERS & SETTERS
	 * 
	 */


	public InputField getfNameField() {
		return fNameField;
	}

	public void setfNameField(InputField fNameField) {
		this.fNameField = fNameField;
	}

	public InputField getlNameField() {
		return lNameField;
	}

	public void setlNameField(InputField lNameField) {
		this.lNameField = lNameField;
	}

	public InputField getAddressField() {
		return addressField;
	}

	public void setAddressField(InputField addressField) {
		this.addressField = addressField;
	}

	public InputField getDobField() {
		return dobField;
	}

	public void setDobField(InputField dobField) {
		this.dobField = dobField;
	}

	public InputField getPhoneField() {
		return phoneField;
	}

	public void setPhoneField(InputField phoneField) {
		this.phoneField = phoneField;
	}

	public InputField getPrescription() {
		return prescription;
	}

	public void setPrescription(InputField prescription) {
		this.prescription = prescription;
	}

	public JTextArea getLogArea() {
		return logArea;
	}

	public void setLogArea(JTextArea logArea) {
		this.logArea = logArea;
	}

	public JTextArea getPrescriptionReason() {
		return prescriptionReason;
	}

	public void setPrescriptionReason(JTextArea prescriptionReason) {
		this.prescriptionReason = prescriptionReason;
	}

	public InputField getSignature() {
		return signature;
	}

	public void setSignature(InputField signature) {
		this.signature = signature;
	}
	
	
	

}
