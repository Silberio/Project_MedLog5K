package com.silberio.controller;
import com.silberio.model.DatabaseConnection;
import com.silberio.model.PatientObject;
import com.silberio.model.PatientQueue;
import com.silberio.view.UserInterfaceMethods;

public class LogSystem {

	private static LogSystem instance = null;

	public static LogSystem getInstance() {
		if (instance == null) {
			instance = new LogSystem();
		}
		return instance;
	}
	
	/*
	 * RESOURCE INSTANTIATION 
	 */
	
	private DatabaseConnection connection = DatabaseConnection.getInstance();
	private DoctorLogging docLog = DoctorLogging.getInstance();
	private PatientLogging patLog = PatientLogging.getInstance();
	private UserInterfaceMethods ui = UserInterfaceMethods.getInstance(); 
	
	private PatientQueue patQueue;
	private PatientObject patient;
	
	/*
	 * MAINFRAME SYSTEM
	 */
	
	public void mainframe() {
		ui.systemInit();
		
		connection.establishConnectionToDatabase();
		connection.getCollection();
		
	}
	
	public void printDocuments() {
		ui.printDocuments(connection, "PatientCollection");
	}
	
	public void initQueueSystem() {
		patQueue = new PatientQueue();
		}

	
}
