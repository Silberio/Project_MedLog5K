package com.silberio.view;

import java.util.Scanner;

import com.silberio.model.DatabaseConnection;

/**
 * Class containing methods for user interface. Currently only a scanner method
 * userInput(); to store user input locally, and a getter for said input.
 * 
 * @author silberio_stalone
 *
 */
public class UserInterfaceMethods implements DocumentFormatting {

	private static UserInterfaceMethods instance = new UserInterfaceMethods();

	public static UserInterfaceMethods getInstance() {
		if (instance == null) {
			instance = new UserInterfaceMethods();
		}
		return instance;
	}

	private Scanner scan = new Scanner(System.in);
	private String input;

	/**
	 * Scans next line from user.
	 * 
	 * @param value
	 *            the name of the attribute user wants to insert
	 */
	public void userInput(String value) {
		//Check that input title is not null
		try {
			if (value.isEmpty() || value == null || value.equals("")) {
				throw new Exception("input value cannot be null !!!");
			}
		} catch (Exception e) {
			//if input is null, title will be DEFAULT
			value = "DEFAULT";
		}
		
		//ask for user input
		System.out.println("Please insert " + value + ": ");	
		//check if input is null. if null, return and ask for input again
		try {
			input = scan.nextLine();
			if (input.isEmpty() || input == null || input.equals("")) {
				throw new Exception("input NULL is invalid !!!");
			}
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * get input from user
	 * 
	 * @return the user input inserted in userInput();
	 */
	public String getInput() {
		return input;
	}
	
	public void userMenu() {
		System.out.println("YmirTech :: MedLog System 5000");
		System.out.println("A) Create new patient file");
		System.out.println("B) Retrieve a patient file");
		System.out.println("C) Report a new M.D.");
	}
	
	public void systemInit() {
		System.out.println(":: Welcome to MedLog System 5000 by YmirTech ::");
	}
	
	public void printDocuments(DatabaseConnection connection, String collectionName) {
		DocumentFormatting.formatPatientObjectDocument(connection, collectionName);
	}
}
