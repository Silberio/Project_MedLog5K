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

	private Iterator<DBObject> iterator = null;

	/*
	 * QUEUE SYSTEM CONTROL
	 */
	private QueueSysControl queueSys = null;

	public QueueSysControl getQueueSys() {
		return queueSys;
	}

	public void setQueueSys(QueueSysControl queueSys) {
		this.queueSys = queueSys;
	}

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
	public void populateQueue() {
		while (iterator.hasNext()) {
				Patient patient = dao.documentToObject(iterator.next());				
				queueSys.addPatientToQueue(patient);
				
			}
	}

	public void initIterator(DBCollection collection) {
		iterator = collection.find().iterator();
	}

}
