package com.silberio.controller;

import com.silberio.model.PatientObject;
import com.silberio.model.PatientQueue;
import com.silberio.view.UserInterfaceMethods;
import com.silberio.view.graphical.MainGUIWindow;
import com.silberio.view.graphical.control.GraphicalUserInterfaceMethods;

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
	private GraphicalUserInterfaceMethods GUIMethods = GraphicalUserInterfaceMethods.getInstance();

	private MainGUIWindow gui;
	private PatientQueue patQueue;
	private PatientObject patient;

	/*
	 * MAINFRAME SYSTEM
	 */

	public void mainframe() {
		// ui.systemInit();

		connection.establishConnectionToDatabase();
		connection.setColletion("PatientCollection");
		connection.getCollection();
		initGUISystem();
		initQueueSystem();
	}

	public void printDocuments() {
		ui.printDocuments(connection, "PatientCollection");
	}

	private void initQueueSystem() {
		patQueue = new PatientQueue();
	}

	private void initGUISystem() {
		gui = new MainGUIWindow();
		GUIMethods.setCollection(connection.getCollection());
		GUIMethods.initQueue();
		connection.loadPatientList(gui.getListPanel());
	}

}
