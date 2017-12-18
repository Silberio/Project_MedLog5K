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
	
	private PriorityQueue<Patient> queue = new PriorityQueue();
	
	public void addPatientToQueue(Patient patient) {
		queue.offer(patient);
		System.out.println(patient.toString() + " added.");
		}
}
