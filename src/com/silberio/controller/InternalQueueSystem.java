package com.silberio.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.JButton;

import org.bson.Document;

import com.silberio.model.PatientObject;

public class InternalQueueSystem {

	/*
	 * SINGLETON INSTANTIATION
	 */
	
	public static InternalQueueSystem instance = null;
	
	public static InternalQueueSystem getInstance() {
		if(instance==null) {
			instance = new InternalQueueSystem();
		} return instance;
	}
	
	/*
	 * END SINGLETON INSTANTIATION
	 */
	
	private PriorityQueue<PatientObject> patientQueue = new PriorityQueue<>();
	private PatientObject patient = null;

	
	public void loadQueue() {
		
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public PriorityQueue<PatientObject> getPatientQueue() {
		return patientQueue;
	}
	public void setPatientQueue(PriorityQueue<PatientObject> patientQueue) {
		this.patientQueue = patientQueue;
	}

	public PatientObject getPatient() {
		return patient;
	}

	public void setPatient(PatientObject patient) {
		this.patient = patient;
	}
	
	
	

	
}
