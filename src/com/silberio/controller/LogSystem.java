package com.silberio.controller;

import java.awt.im.spi.InputMethod;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.bson.Document;

import com.silberio.model.PatientObject;
import com.silberio.view.UserInterfaceMethods;
import com.silberio.view.graphical.MainGUIWindow;
import com.silberio.view.graphical.control.InputPanelMethods;
import com.silberio.view.graphical.control.ListPanelMethods;
import com.silberio.view.graphical.control.OutputPanelMethods;
import com.silberio.view.graphical.model.InputPanel;

public class LogSystem {

	private static LogSystem instance = null;

	public static LogSystem getInstance() {
		if (instance == null) {
			instance = new LogSystem();
		}
		return instance;
	}

	/*
	 * RESOURCE INSTANTIATION
	 */

	private DatabaseConnection connection = DatabaseConnection.getInstance();
	private UserInterfaceMethods ui = UserInterfaceMethods.getInstance();
	
	private InputPanelMethods inputMethods = InputPanelMethods.getInstance();
	private OutputPanelMethods outputMethods = OutputPanelMethods.getInstance();
	private ListPanelMethods listMethods = ListPanelMethods.getInstance();
	private InternalQueueSystem queueSystem = InternalQueueSystem.getInstance();

	private MainGUIWindow gui;

	Iterator<Document> iterator = null;
	
	/*
	 * MAINFRAME SYSTEM
	 */

	public void mainframe() {
		// ui.systemInit();

		connection.establishConnectionToDatabase();
		connection.setColletion("PatientCollection");
		connection.getCollection();
		
		initGUISystem();
		initIterator();
		initInternalMethods();
		initButtonListeners();
		}

	public void printDocuments() {
		ui.printDocuments(connection, "PatientCollection");
	}


	private void initGUISystem() {
		gui = new MainGUIWindow();

	}
	
	/**
	 * Global iterator initialization
	 */
	private void initIterator() {
		iterator = connection.getCollection().find().iterator();

		outputMethods.setIterator(iterator);
		listMethods.setIterator(iterator);
	}
	
	/**
	 * Initiates all methods to be used by internal classes,
	 * such as methods for input, output and the graphical
	 * list 
	 * <p>
	 * 
	 * </p>
	 */
	private void initInternalMethods() {
		
		inputMethods.setCollection(connection.getCollection());
		inputMethods.setConnection(connection);
		inputMethods.setInputPanel(gui.getInputPanel());
		inputMethods.setQueue(queueSystem.getPatientQueue());
		
		outputMethods.setCollection(connection.getCollection());
		outputMethods.setConnection(connection);
		outputMethods.setOutputPanel(gui.getOutputPanel());
		
		listMethods.setCollection(connection.getCollection());
		listMethods.setConnection(connection);
		
		listMethods.setListPanel(gui.getListPanel());
		listMethods.setInputPanel(gui.getInputPanel());
		
		outputMethods.setqSys(this.queueSystem);
		}
	
	private void initButtonListeners() {

		//Input button
		inputMethods.inputButtonListener(gui.getInputPanel().getInputBtn());
		
		//Retrieve button
		outputMethods.retrieveButtonListener(gui.getOutputPanel().getRetrieveBtn());
		//Edit button
		outputMethods.editButtonListener(gui.getOutputPanel().getEditBtn());
		
		//Update button
		outputMethods.updateButtonListener(gui.getOutputPanel().getUpdateBtn());
		
	}

	/*
	 * GETTERES AND SETTERS
	 */
	public InternalQueueSystem getQueueSystem() {
		return queueSystem;
	}

	public void setQueueSystem(InternalQueueSystem queueSystem) {
		this.queueSystem = queueSystem;
	}
	
	


}
