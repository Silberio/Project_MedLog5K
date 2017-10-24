package com.silberio.view.graphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.silberio.view.graphical.model.GUIArray;

public class PatientFileDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color medLogTan = new Color(232, 192, 132);
	private JLabel label;
	JTextField outputField;
	JTextArea nameField, addressField, dobField, phoneField;
	private GUIArray array = GUIArray.getInstance();

	public PatientFileDisplay() {
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		this.setBackground(medLogTan);
		this.setLayout(grid);
		this.setBorder(BorderFactory.createEmptyBorder(1, 2, 2, 2));
		this.add(Box.createRigidArea(new Dimension(0, 5)));

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(outputLabel("Name: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(nameField = new JTextArea(1,20), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(outputLabel("Address: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(addressField = new JTextArea(1,20), gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(outputLabel("D.o.B.: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(dobField = new JTextArea(1,20), gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(outputLabel("Telephone: "), gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(phoneField = new JTextArea(1,20), gbc);
	}

	private JLabel outputLabel(String fieldDisplayName) {
		label = new JLabel(fieldDisplayName);
		
		return label;
	}
	
	public void displayInfo(String name, String address, String dob, String phone) {
		nameField.setText(name);
		addressField.setText(address);
		dobField.setText(dob);
		phoneField.setText(phone);
	}
}
