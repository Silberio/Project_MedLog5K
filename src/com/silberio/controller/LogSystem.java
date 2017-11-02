package com.silberio.controller;

import com.silberio.model.PatientObject;
import com.silberio.model.PatientQueue;
import com.silberio.view.UserInterfaceMethods;
import com.silberio.view.graphical.MainGUIWindow;
import com.silberio.view.graphical.control.GraphicalUserInterfaceMethods;
import com.silberio.view.graphical.control.InputPanelMethods;
import com.silberio.view.graphical.control.ListPanelMethods;
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
	private GraphicalUserInterfaceMethods GUIMethods = GraphicalUserInterfaceMethods.getInstance();
	
	private InputPanelMethods inputMethods = InputPanelMethods.getInstance();
	private OutputPanelMethods outputMethods = OutputPanelMethods.getInstance();
	private ListPanelMethods listMethods = ListPanelMethods.getInstance();
	
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
		initInternalMethods();
		initButtonListeners();
	}

	public void printDocuments() {
		ui.printDocuments(connection, "PatientCollection");
	}


	private void initGUISystem() {
		gui = new MainGUIWindow();

	}
	
	private void initInternalMethods() {
		inputMethods.setCollection(connection.getCollection());
		inputMethods.setConnection(connection);
		
		outputMethods.setCollection(connection.getCollection());
		outputMethods.setConnection(connection);
		
		listMethods.setListPanel(gui.getListPanel());
		listMethods.setInputPanel(gui.getInputPanel());
	}
	
	private void initButtonListeners() {
		//Input button
		inputMethods.inputButtonListener(gui.getInputPanel().getInputBtn(), gui.getInputPanel());
		listMethods.insertPatientToList(gui.getInputPanel().getInputBtn(), gui.getListPanel());
		
		//Retrieve button
		outputMethods.retrieveButtonListener(gui.getOutputPanel().getRetrieveBtn(), gui.getOutputPanel());
		//Edit button
		outputMethods.editButtonListener(gui.getOutputPanel().getEditBtn(), gui.getOutputPanel());
		
		//Update button
		outputMethods.updateButtonListener(gui.getOutputPanel().getUpdateBtn(), gui.getOutputPanel());
	}
	
	private void initGUIPatientList() {
		
	}

}
