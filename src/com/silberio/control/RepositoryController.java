package com.silberio.control;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

/**
 * Creates a connection with the Mongo Database with hardcoded credentials
 * 
 * @author bish0p
 *
 */
public class RepositoryController {

	private static RepositoryController instance = null;

	public static RepositoryController getInstance() {
		if (instance == null) {
			instance = new RepositoryController();
		}
		return instance;
	}

	private MongoCredential credential;
	private MongoClient mongo;
	private DB db;
	private DBCollection col;

	public void establishConnection() {
		mongo = new MongoClient("localhost", 27017);
		db = new DB(mongo, "MedLogDB");

		credential = MongoCredential.createCredential("silberio", "medlog5kDB", "".toCharArray());
		System.out.println("Connected to DB");

		col = db.getCollection("PatientCollection");
		System.out.println("Selected PatientCollection");
	}
	
	public DBCollection getCollection() {
		return col;
	}
}
