package com.silberio.view;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.silberio.controller.DatabaseConnection;

public interface DocumentFormatting {

	public static void printAll(DatabaseConnection connection) {
		connection.setColletion("PatientCollection");
		MongoCollection<Document> collection = connection.getCollection();

		Iterator<Document> colIter = collection.find().iterator();

		while (colIter.hasNext()) {
			System.out.println(colIter.next().get("first_name"));
		}
	}

	public static void formatPatientObjectDocument(DatabaseConnection connection, String collectionName) {
		connection.setColletion(collectionName);
		MongoCollection<Document> collection = connection.getCollection();

		Iterator<Document> iterator = collection.find().iterator();

		while (iterator.hasNext()) {
			System.out.println("Name: " + iterator.next().get("last_name") + ", " + iterator.next().get("first_name"));
			System.out.println("Address: " + iterator.next().get("address"));
			System.out.println("Date of Birth: " + iterator.next().get("DoB"));
			System.out.println("Patient log:\n" + iterator.next().get("patient_log"));
			System.out.println("Prescription: " + iterator.next().get("perscription"));
			System.out.println();
		}
	}
}
