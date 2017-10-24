package com.silberio.model;

import java.util.PriorityQueue;

public class PatientQueue {

	private static PriorityQueue<PatientObject> queue = null;

	public PatientQueue(){
		queue = new PriorityQueue<PatientObject>();
	}
	 
	public PriorityQueue<PatientObject> getQueue() {
		return queue;
	}


	/**
	 * inserts a patient into the queue
	 * 
	 * @param patient
	 *            the patient object to be inserted
	 */
	public void insertPatientIntoQueue(PatientObject patient) {
		queue.offer(patient);
		System.out.println(patient.toString() + " :: Added to queue.");
	}

	/**
	 * Gets the first patient (head element) from the patient queue and removes it
	 * from queue
	 * 
	 * @return head element patient
	 */
	public PatientObject getFirstPrioPatient() {
		PatientObject patient = queue.poll();
		return patient;
	}
	
	public PatientObject peekFirstPrioPatient() {
		PatientObject patient = queue.peek();
		System.out.println(patient.toString() + " :: Removed from queue");
		return patient;
	}
	

}
