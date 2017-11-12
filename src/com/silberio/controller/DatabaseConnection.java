package com.silberio.controller;

import java.io.Serializable;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.silberio.view.graphical.model.ListPanel;

/**
 * Singleton class for instantiating connection to server.
 * 
 * @author silberio_stalone
 *
 */
public class DatabaseConnection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static DatabaseConnection instance = null;

	private MongoCredential credential;
	private MongoClient mongo;
	private MongoDatabase database;
	private MongoCollection<Document> collection;

	protected DatabaseConnection() {

	}

	/**
	 * Instantiates an instance of DatabaseConnection in singleton pattern.
	 * 
	 * @return DatabaseConnection instance
	 */
	public static DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	/**
	 * <p>
	 * Sets up a connection between client and server.
	 * </p>
	 * <p>
	 * The connection is stablished to a local MongoDB database at localhost. First,
	 * an instance of MongoClient is created. Next, MongoCredential is instantiated
	 * with default credentials; later on, the method will be able to take
	 * parameters for username, database and password.
	 * </p>
	 */
	public void establishConnectionToDatabase() {
		// Create connection to DB
		mongo = new MongoClient("localhost", 27017);

		// Create credentials

		credential = MongoCredential.createCredential("silberio", "medlog5kDB", "".toCharArray());
		System.out.println("Connected to database succesfully");

		// Accessing the database
		database = mongo.getDatabase("MedLogDB");
		System.out.println("Credentials ::" + credential.toString());
	}

	/**
	 * retrieve a collection from the database
	 * 
	 * @param collectionName
	 *            the name of the chose collection.
	 *            <p>
	 *            throws EmptyCollectionNameException if collectionName is empty.
	 *            Exception still untested
	 *            </p>
	 */
	public void setColletion(String collectionName) {
		// try {
		// if (collectionName == null || collectionName.isEmpty() ||
		// collectionName.equals(" ")) {
		// throw new CollectionNameEmptyException();
		// }
		collection = database.getCollection(collectionName);
		// } catch (Exception e) {
		// collectionName = null;
		// }

		// retrieve collection
		System.out.println("Collection " + collectionName + " selected");
	}

	/**
	 * Creates a new collection in the database. Exceptions are <b>not</b> yet
	 * tested.
	 * <p>
	 * Exception handler needed. This method is only used for debugging and
	 * behind-the-scenes purposes and not intended for an actual user to access.
	 * </p>
	 * 
	 * @param collection
	 * 
	 */
	public void createCollection(String collection) {
		// create a collection
		database.createCollection(collection);
		System.out.println("Collection " + collection + " created succesfully");

	}

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
	 * Retrieves a MongoDB collection from the database
	 * 
	 * @return the collection to be retrieved
	 */
	public MongoCollection<Document> getCollection() {
		return collection;
	}
}
