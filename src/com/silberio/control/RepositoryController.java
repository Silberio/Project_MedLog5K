package com.silberio.control;

import java.util.Iterator;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
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

	/**
	 * Sets a connection to the database with hardcoded credentials, server address and collection
	 */
	public void establishConnection() {
		mongo = new MongoClient("localhost", 27017);
		db = new DB(mongo, "MedLogDB");

		credential = MongoCredential.createCredential("silberio", "medlog5kDB", "".toCharArray());
		System.out.println("Connected to DB");
		
		//Initializes the collection object used in the application
		col = db.getCollection("PatientCollection");
		System.out.println("Selected PatientCollection");
	}
	
	/**
	 * Retrieves the db collection for patients in the Mongo Database
	 * @return DBCollection "PatientCollection" 
	 */
	public DBCollection getCollection() {
		return col;
	}
	
	public Iterator<DBObject> getDBIterator() {
		Iterator<DBObject> iterator = col.find().iterator();
		return iterator;
	}
	/**
	 * Inserts a patient into the database collection
	 * @param patient the POJO to be inserted
	 */
	public void inputPatient(DBObject patient) {
		col.insert(patient);
	}
}
