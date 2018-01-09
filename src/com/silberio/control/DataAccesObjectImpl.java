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

	public Patient documentToObject(DBObject document);

	public DBObject objectToDocument(Patient patient);
	
	/*
	 * VIEW CONTROLLER METHODS 
	 */
	public void inputPatient(DBObject patient);
	
	public Patient retrievePatient();
	
	public void editPatient(DBObject patient, DBObject updatedPatient);
	
	public Patient removePatient();

}
