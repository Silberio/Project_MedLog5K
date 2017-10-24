package com.silberio.view.graphical;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.silberio.view.graphical.control.GraphicalUserInterfaceMethods;
import com.silberio.view.graphical.model.GUIArray;
import com.silberio.view.graphical.model.InputPanel;

public class MainGUIWindow {

	private static InputPanel inputPanel = InputPanel.getInstance();
	private static GraphicalUserInterfaceMethods GUIMethods = GraphicalUserInterfaceMethods.getInstance();

	private PatientFileDisplay infoPanel = new PatientFileDisplay();
	private GUIArray guiArray = new GUIArray();
	private JPanel buttonPanel = new JPanel();

	private JFrame frame;
	private JPanel panelWest;
	private JPanel panelEast;
	private JButton infoInputButton = inputPanel.getInputBtn();
	
	private final Color MEDLOGTAN = new Color(232, 192, 132);

	public MainGUIWindow() {
		initGUI();
		launchFrame();
		System.out.println("GUI initiated");
	}

	private void initGUI() {
		frame = new JFrame(); // default layout manager is BorderLayout
		panelWest = new JPanel();
		panelEast = new JPanel();

		buttonPanel.setBackground(MEDLOGTAN);
		GUIMethods.inputButtonListener(inputPanel.getInputBtn(), inputPanel);
	}

	public void storeInputInGUIMethods(int row) {
		/*
		 * get input from input fields on inputPanel and store them in GUIMethods
		 * as strings
		 */
		GUIMethods.setInfoFromGUI(
				inputPanel.getfNameField().getText(), 
				inputPanel.getlNameField().getText(),
				inputPanel.getDobField().getText(), 
				inputPanel.getAddressField().getText(),
				inputPanel.getPhoneField().getText(), 
				inputPanel.getLogArea().getText(),
				inputPanel.getPrescription().getText(), 
				inputPanel.getPrescriptionReason().getText(),
				inputPanel.getSignature().getText());
	}
	
	/**
	 * Launches JFrame with initiated values
	 */
	private void launchFrame() {

		panelWest.add(inputPanel);
		panelWest.setBackground(MEDLOGTAN);

		panelEast.add(infoPanel);
		panelEast.setBackground(MEDLOGTAN);

		frame.add(panelWest, BorderLayout.WEST);
		frame.add(panelEast, BorderLayout.EAST);

		frame.setTitle("MedLog System 5000 : : by SilbTech");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public JButton getInfoInputButton() {
		return infoInputButton;
	}

	public void setInfoInputButton(JButton infoInputButton) {
		this.infoInputButton = infoInputButton;
	}

	public GUIArray getGuiArray() {
		return guiArray;
	}

	public void setGuiArray(GUIArray guiArray) {
		this.guiArray = guiArray;
	}
	
}
