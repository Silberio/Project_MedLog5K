package com.silberio.controller;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.silberio.model.PatientObject;

public abstract class Logging {

	/**
	 * Abstract class to be implemented in respective classes. Used for creating an
	 * object to be logged later.
	 */
	public abstract void createLoggingObject();

	private String fileId;
	private int uniqueId;

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
	 * gets the created id
	 * 
	 * @return
	 */
	public String getFileId() {
		return fileId;
	}

}
