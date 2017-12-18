package com.silberio.control;

import java.util.Iterator;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.silberio.model.Patient;

public class LogSystem {

	private static LogSystem instance = null;

	
	public static LogSystem getInstance() {
		if (instance == null) {
			instance = new LogSystem();
		}
		return instance;
	}
	
	private DataAccesObject dao = DataAccesObject.getInstance();
	private QueueSysControl queueSys = QueueSysControl.getInstance();
	private Iterator<DBObject> iterator = null;
	
	/**
	 * Populates the priority queue with all existing data on DB
	 */
	public void populateQueue() {
		while(iterator.hasNext()) {
			Patient patient = dao.documentToObject(iterator.next());
			System.out.println(patient.toString());
		}
	}
	
	public void initIterator(DBCollection collection) {
		iterator = collection.find().iterator();
	}
	
}
