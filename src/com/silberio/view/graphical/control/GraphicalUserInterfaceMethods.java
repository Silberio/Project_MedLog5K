package com.silberio.view.graphical.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.silberio.controller.DatabaseConnection;
import com.silberio.model.PatientObject;
import com.silberio.model.PatientQueue;
import com.silberio.view.graphical.model.ListPanel;
import com.silberio.view.graphical.model.OutputPanel;
import com.silberio.view.graphical.model.SearchPanel;

public class GraphicalUserInterfaceMethods {

	/*
	 * SINGLETON INSTANTIATION
	 */
	private static GraphicalUserInterfaceMethods instance = null;

	public static GraphicalUserInterfaceMethods getInstance() {
		if (instance == null) {
			instance = new GraphicalUserInterfaceMethods();
		}
		return instance;
	}
	/*
	 * END SINGLETON INSTANTIATION
	 */
	
	private PatientObject patient;
	private MongoCollection<Document> collection;
	private DatabaseConnection connection;

	

	

	/*
	 * 
	 * GETTERS & SETTERS
	 * 
	 */



	public PatientObject getPatient() {
		return patient;
	}



	public void setPatient(PatientObject patient) {
		this.patient = patient;
	}



	public MongoCollection<Document> getCollection() {
		return collection;
	}



	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}



	public DatabaseConnection getConnection() {
		return connection;
	}



	public void setConnection(DatabaseConnection connection) {
		this.connection = connection;
	}

	
	
	

}
