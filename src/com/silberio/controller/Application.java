package com.silberio.controller;

import com.silberio.model.DatabaseConnection;

public class Application {
	public static void main(String[] args) {
		DatabaseConnection connection = DatabaseConnection.getInstance();

		PatientLogging logging = PatientLogging.getInstance();

		connection.establishConnectionToDatabase();
		connection.retrieveColletion("PatientCollection");

		// To add a new file, setNewPatientDocument() in logging class, pass a
		// connection and patient details. You have to retrieve a collectoin first through connection class retrieveCollection.
		logging.createNewPatient();
		logging.patientObjectToDocument(logging.getPatient());
		logging.insertNewPatientDocument(connection.getCollection(), logging.getPatientDocument());


		//
		// System.out.println(roger.toString());
		// System.out.println(roger.getPatientLog() + "\n" + roger.getPrescription());
	}
}
