package com.silberio.controller;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.silberio.model.DoctorObject;
import com.silberio.model.PatientObject;

public abstract class Logging {

	
	private String fileId;

	/**
	 * Abstract method to be implemented in respective classes. Used for creating an
	 * object to be logged later.
	 */
	public abstract void createLoggingObject();
	
	public abstract void objectToDocument();
	
	/**
	 * inserts a document into a collection
	 * 
	 * @param collection
	 * @param document
	 */
	public void insertDocument(MongoCollection<Document> collection, Document document) {

		collection.insertOne(document);
	}

	/**
	 * sets a file ID for mongoDB documents
	 * 
	 */
	public void setFileId() {
		
	}
	/**
	 * returns a file ID
	 * 
	 * @return
	 */
	public String getFileId() {
		return fileId;
	}

}
