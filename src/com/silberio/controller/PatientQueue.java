package com.silberio.controller;

import java.util.PriorityQueue;

import com.silberio.model.PatientObject;

public class PatientQueue {

	PriorityQueue<PatientObject> queue = new PriorityQueue<PatientObject>();
	
	public void printQueue() {
		System.out.printf("%s", queue);
		System.out.println();
	}
	
	//To insert a patient, do something like patientQ.insertPateitntIntoQueu(connection.getPatient)
	//or something like that
	public void insertPatientIntoQueue(PatientObject patient) {
		queue.offer(patient);
		System.out.println(patient.toString() + " :: Added to queue.");
	}
	

}
