package com.silberio.view.graphical.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.PriorityQueue;

import javax.swing.JButton;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.silberio.controller.DatabaseConnection;
import com.silberio.model.PatientObject;
import com.silberio.view.graphical.model.InputPanel;
import com.silberio.view.graphical.model.ListPanel;

public class ListPanelMethods {
	/*
	 * SINGLETON INSTANTIATION
	 */
	private static ListPanelMethods instance = null;
	
	public static ListPanelMethods getInstance() {
		if(instance==null) {
			instance = new ListPanelMethods();
		}	return instance;
	}
	/*
	 * END SINGLETON INSTANTIATION
	 */
	
	private PatientObject patient =  null;
	private ListPanel listPanel = null;
	private PriorityQueue<PatientObject> queue;
 
	/**
	 * Listener for outputPanel button to remove selected patient
	 * 
	 * @param btn
	 * @param outputPanel
	 * @param listPanel
	 */

	
	/**
	 * displays input patient file in the list
	 */
	public void displayPatientOnList() {
//		queue.forEach(po -> listPanel.getModel().addElement(po.toString()));
		 
		do {
			String pat = queue.poll().toString();
			listPanel.getModel().addElement(pat);
		} while(queue.isEmpty()==false);
	}

	
	/*
	 * GETTERS AND SETTERS
	 */

	public PatientObject getPatient() {
		return patient;
	}
	
	public void setPatient(PatientObject patient) {
		this.patient = patient;
	}
	
	public ListPanel getListPanel() {
		return listPanel;
	}
	
	public void setListPanel(ListPanel listPanel) {
		this.listPanel = listPanel;
	}


	public PriorityQueue<PatientObject> getQueue() {
		return queue;
	}


	public void setQueue(PriorityQueue<PatientObject> queue) {
		this.queue = queue;
	}
	
	

}
