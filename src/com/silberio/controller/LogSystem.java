package com.silberio.controller;
import com.silberio.model.DatabaseConnection;
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



	// To add a new file, setNewPatientDocument() in logging class, pass a
	// connection and patient details. You have to retrieve a collectoin first through connection class retrieveCollection.
//	logging.createLoggingObject();
//	logging.doctorObjectToDocument(logging.getDoctorObject());
//	logging.insertDocument(connection.getCollection(), logging.getDoctorDocument());

	//
	// System.out.println(roger.toString());
	// System.out.println(roger.getPatientLog() + "\n" + roger.getPrescription());
	
	
}
