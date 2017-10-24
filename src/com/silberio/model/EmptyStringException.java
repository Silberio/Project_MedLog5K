package com.silberio.model;

public class EmptyStringException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyStringException(String string) {
		if(string == null ||string.equals("")||string.equals(" ")) {
			System.out.println("input value empty. cannot be empty !!!");
		}
	}
}
