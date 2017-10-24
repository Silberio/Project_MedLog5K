package com.silberio.view.graphical.model;

import javax.swing.JLabel;

public class OutputField extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String value;
	
	public OutputField(String id) {
		this.setText(value);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
