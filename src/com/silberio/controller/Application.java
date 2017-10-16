package com.silberio.controller;

import com.silberio.model.DatabaseConnection;

public class Application {
	public static void main(String[] args) {
		DatabaseConnection connection = DatabaseConnection.getInstance();

		DoctorLogging logging = DoctorLogging.getInstance();
//
//		connection.establishConnectionToDatabase();
//		connection.retrieveColletion("DoctorCollection");

		// To add a new file, setNewPatientDocument() in logging class, pass a
		// connection and patient details. You have to retrieve a collectoin first through connection class retrieveCollection.
//		logging.createLoggingObject();
//		logging.doctorObjectToDocument(logging.getDoctorObject());
//		logging.insertDocument(connection.getCollection(), logging.getDoctorDocument());

		//
		// System.out.println(roger.toString());
		// System.out.println(roger.getPatientLog() + "\n" + roger.getPrescription());
	}
}
