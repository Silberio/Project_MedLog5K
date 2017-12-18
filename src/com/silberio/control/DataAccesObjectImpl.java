package com.silberio.control;

import com.mongodb.DBObject;
import com.silberio.model.Patient;

/**
 * Interface containing DAO methods
 * <p>
 * These methods handle any data coming from and going to the database
 * </p>
 * 
 * @author bish0p
 *
 */
public interface DataAccesObjectImpl {

	//Maybe return Patient obj
	public Patient documentToObject(DBObject document);

	//maybe return basicDBobj
	public DBObject objectToDocument(Patient patient);

}
