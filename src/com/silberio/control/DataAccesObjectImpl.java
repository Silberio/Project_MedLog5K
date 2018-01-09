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

/**
 * Takes in a patient POJO and converts it to a DB Object
 * @param patient the patient object to be converted
 * @return a DBObject with the info from <i>patient</i>
 */
	public DBObject objectToDocument(Patient patient);
	
	/*
	 * VIEW CONTROLLER METHODS 
	 */
	public void inputPatient(DBObject patient);
	
	public Patient retrievePatient();
	
	public void editPatient(Patient patient, Patient updatedPatient);
	
	public Patient removePatient(Patient patient);

}
