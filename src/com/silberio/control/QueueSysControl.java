package com.silberio.control;

import java.util.PriorityQueue;

import com.silberio.model.Patient;

public class QueueSysControl {
	
	private static QueueSysControl instance = null;
	
	public static QueueSysControl getInstance() {
		if(instance==null) {
			instance = new QueueSysControl();
		} return instance;
	}
	
	private PriorityQueue<Patient> queue = new PriorityQueue<Patient>();
	
	
	public void addPatientToQueue(Patient patient) {
		queue.offer(patient);
		System.out.println(patient.toString() + " added.");
		}
	
	/**
	 * Retrieves head element but does not remove it
	 * @return
	 */
	public Patient peek() {
		Patient patient = queue.peek();
		return patient;
	}
	
	/**
	 * Retrieves and removes head element
	 * @return
	 */
	public Patient poll() {
		Patient patient = queue.poll();
		return patient;
	}

	public PriorityQueue<Patient> getQueue() {
		return queue;
	}

	public void setQueue(PriorityQueue<Patient> queue) {
		this.queue = queue;
	}
	
	
}
