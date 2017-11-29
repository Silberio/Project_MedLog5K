package com.silberio.controller;

import java.util.Iterator;

import org.bson.Document;

import com.silberio.view.UserInterfaceMethods;
import com.silberio.view.graphical.MainGUIWindow;
import com.silberio.view.graphical.control.InputPanelMethods;
import com.silberio.view.graphical.control.OutputPanelMethods;

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
	private InternalQueueSystem queueSystem = InternalQueueSystem.getInstance();

	private MainGUIWindow gui;

	Iterator<Document> iterator = null;

	/*
	 * MAINFRAME SYSTEM
	 */

	public void mainframe() {
		// ui.systemInit();

		establishConnection();

		initGUISystem();
		setListToInternalQueue();
		initIterator();
		initQueueSys();
		initInternalMethods();
		initButtonListeners();
	}

	private void establishConnection() {
		connection.establishConnectionToDatabase();
		connection.setColletion("PatientCollection");
		connection.getCollection();

		inputMethods.setCollection(connection.getCollection());
		inputMethods.setConnection(connection);

		outputMethods.setCollection(connection.getCollection());
		outputMethods.setConnection(connection);

		inputMethods.setQueue(queueSystem.getPatientQueue());
		outputMethods.setQueue(queueSystem.getPatientQueue());
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
		queueSystem.setIterator(iterator);
	}

	/**
	 * Initiates all methods to be used by internal classes, such as methods for
	 * input, output and the graphical list
	 * <p>
	 * 
	 * </p>
	 */
	private void initInternalMethods() {
		inputMethods.setInputPanel(gui.getInputPanel());

		outputMethods.setOutputPanel(gui.getOutputPanel());

	}

	/**
	 * initiates all the button listeners
	 */
	private void initButtonListeners() {

		// Input button
		inputMethods.inputButtonListener(gui.getInputPanel().getInputBtn());

		// Retrieve button
		outputMethods.retrieveButtonListener(gui.getOutputPanel().getRetrieveBtn());

		// Remove button
		outputMethods.outputButtonListener(gui.getOutputPanel().getOutputBtn());

		// Edit button
		outputMethods.editButtonListener(gui.getOutputPanel().getEditBtn());

		// Update button
		outputMethods.updateButtonListener(gui.getOutputPanel().getUpdateBtn());

	}

	private void setListToInternalQueue() {
		queueSystem.setListPanel(gui.getListPanel());
		inputMethods.setListPanel(gui.getListPanel());
		outputMethods.setListPanel(gui.getListPanel());
	}

	private void initQueueSys() {
		queueSystem.loadQueue();
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
