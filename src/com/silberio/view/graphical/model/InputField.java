package com.silberio.view.graphical.model;

import javax.swing.JTextField;

public class InputField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String value;
	
	public InputField(String fieldId) {
		this.setColumns(15);
		this.id = fieldId;
	}

	public String getId() {
		return id;
	}

	public String getValue() {
		value = this.getText();
		return value;
	}
	

}
