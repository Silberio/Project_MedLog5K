package com.silberio.model;

public class EmptyStringException extends Exception {

	public EmptyStringException(String string) {
		if(string == null ||string.equals("")||string.equals(" ")) {
			System.out.println("input value empty. cannot be empty !!!");
		}
	}
}
