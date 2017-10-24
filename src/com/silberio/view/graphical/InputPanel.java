package com.silberio.view.graphical;

import java.awt.Button;
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
import javax.swing.JTextField;

import com.silberio.view.graphical.model.InputField;

public class InputPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static InputPanel instance = null;
	
	public static InputPanel getInstance() {
		if(instance == null) {
			instance = new InputPanel();
		}
		return instance;
	}
	
	private Color medLogTan = new Color(232, 192, 132);
	private InputField inputField = null;
	private InputField nameField, addressField, dobField, phoneField;
	private JButton inputBtn = new JButton("Input Info");
	private JLabel label = null;
	
	
	
	public InputPanel() {
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.setBackground(medLogTan);
		this.setLayout(grid);
		this.setBorder(BorderFactory.createEmptyBorder(1, 2, 2, 2));
		this.add(Box.createRigidArea(new Dimension(0, 5)));
		
		gbc.insets = new Insets(4, 0, 5, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(label = new JLabel("Name: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(nameField = new InputField("name"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(label = new JLabel("Address: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(addressField = new InputField("address"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(label = new JLabel("D.o.B.: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(dobField = new InputField("dob"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(label = new JLabel("Telephone: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(phoneField = new InputField("phone"), gbc);
		
		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.weighty = 10;
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(inputBtn, gbc);
		
	}
	
	public String getFieldContent(String fieldId) {
		inputField.setId(fieldId);
		String input = inputField.getText();
		return input;
	}
	

	public JButton getInputBtn() {
		return inputBtn;
	}

	public void setInputBtn(JButton inputBtn) {
		this.inputBtn = inputBtn;
	}

	public JTextField getInputField() {
		
		return inputField;
	}
	
	/*
	 * 
	 * GETTERS & SETTERS
	 * 
	 */

	public void setInputField(InputField inputField) {
		this.inputField = inputField;
	}

	public InputField getNameField() {
		return nameField;
	}

	public void setNameField(InputField nameField) {
		this.nameField = nameField;
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
	
	
	
	
	

}
