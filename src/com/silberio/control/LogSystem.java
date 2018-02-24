package com.silberio.control;

import java.util.Iterator;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.silberio.model.Patient;

/**
 * Contains control for the whole application services
 * <p>
 * This class is created as a singleton instance and contains its' own instance
 * of a Queue System Controller which is later injected thru getters and
 * setters.
 * </p>
 * It also containes a DBOBject iterator, which also is set with getters and is
 * to be used globally by the app. The iterator is initialized with information
 * from a Mongo Database
 * 
 * @author silberio_stalone
 *
 */
public class LogSystem {

	private static LogSystem instance = null;

	/**
	 * Creates a single instance of the class
	 * @return LogSystem() instance
	 */
	public static LogSystem getInstance() {
		if (instance == null) {
			instance = new LogSystem();
		}
		return instance;
	}

	private Iterator<DBObject> iterator = null;

	/*
	 * DAO CONTROL
	 */
	private DataAccesObject dao = null;

	public DataAccesObject getDao() {
		return dao;
	}

	public void setDao(DataAccesObject dao) {
		this.dao = dao;
	}

	/**
	 * Populates the priority queue with all existing data on DB
	 */
	public void populateQueue(QueueSysControl queueSys) {
		while (iterator.hasNext()) {
			Patient patient = dao.documentToObject(iterator.next());
			queueSys.addPatientToQueue(patient);			
		}
	}

	
	/**
	 * Initializes the global iterator with a Mongo database collection object
	 * @param collection
	 */
	public void initIterator(DBCollection collection) {
		iterator = collection.find().iterator();
	}
	
	public void initIterator(Iterator<DBObject> iterator) {
		this.iterator = iterator;
	}

	public Iterator<DBObject> getIterator() {
		return iterator;
	}	

}
