package com.silberio.control;

import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.silberio.model.Patient;

/**
 * Controller for search methods and the likes
 * @author silberio_stalone
 *
 */
public class SearchControl {

	private DataAccesObject dao = null;
	private Patient p = null;

	/**
	 * Empty constructor
	 */
	public SearchControl() {

	}

	/**
	 * Creates a new instance of this class and initializes it with a data access object module
	 * @param dao
	 */
	public SearchControl(DataAccesObject dao) {
		this.dao = dao;
	}

	/**
	 * Search function for finding a patient by date of birth
	 * @param dob
	 */
	public void searchFunction(int dob) {
		
	}
	
	/**
	 * Search function for finding a patient by names
	 * <p>
	 * Works with either first, last or both names.
	 * </p>
	 * @param name
	 */
	public void searchFunction(String name) {
		if (name.equals("") || name == null || name.equals("")) {
			JOptionPane.showMessageDialog(null, "Field is Empty!");
			p = new Patient("EMPTY");
		} else {
			String names[] = name.split("\\s+");
			
			if (names.length >= 2) {
				findByBothNames(names[0], names[1]);
			} else
				findByOneName(names[0]);
		}
	};

	/**
	 * Find a patient file by both names
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	private void findByBothNames(String firstName, String lastName) {

		DBObject query = new BasicDBObject();
		query.put("first_name", firstName);
		query.put("last_name", lastName);

		p = getPatientFromDao(query);
	}

	private void findByOneName(String name) {
		if(byLastName(name).getFirstName().equals("EMPTY")) {
			p = byFirstName(name);
		} else
			p = byLastName(name);
	}

	private Patient byLastName(String name) {
		DBObject query = new BasicDBObject();
		query.put("last_name", name);
		return getPatientFromDao(query);
	}

	private Patient byFirstName(String name) {
		DBObject query = new BasicDBObject();
		query.put("first_name", name);
		return getPatientFromDao(query);
	}

	private Patient findByDoB(String dob) {
		DBObject query = new BasicDBObject();
		query.put("DoB", dob);

		return getPatientFromDao(query);
	}

	private Patient getPatientFromDao(DBObject query) {
		if(dao.getCol().findOne(query) == null) {
			return new Patient("EMPTY");
		} else {
			DBObject patient = dao.getCol().findOne(query);
			return dao.documentToObject(patient);
		}	
	}
	
	public Patient getPatient() {
		return p;
	}

}
