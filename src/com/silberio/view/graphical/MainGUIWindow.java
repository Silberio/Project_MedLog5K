package com.silberio.view.graphical;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.silberio.view.graphical.model.InputPanel;
import com.silberio.view.graphical.model.ListPanel;
import com.silberio.view.graphical.model.OutputPanel;
import com.silberio.view.graphical.model.SearchPanel;

public class MainGUIWindow {

	private InputPanel inputPanel = InputPanel.getInstance();
	private OutputPanel outputPanel = OutputPanel.getInstance();
	
	private ListPanel listPanel = new ListPanel();
	private SearchPanel searchPanel = new SearchPanel();
	
	private JFrame frame;
	private JPanel panelWest;
	private JPanel panelEast;
	private JPanel panelCenter;
	private JPanel panelSouth;
	
	private final Color MEDLOGTAN = new Color(173, 142, 97);

	public MainGUIWindow() {
		initGUI();
		launchFrame();
		System.out.println("GUI initiated");
	}

	private void initGUI() {
		frame = new JFrame(); // default layout manager is BorderLayout
		panelWest = new JPanel();
		panelEast = new JPanel();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
	}
	
	/**
	 * Launches JFrame with initiated values
	 */
	private void launchFrame() {

		panelWest.add(inputPanel);
		panelWest.setBackground(MEDLOGTAN);

		panelEast.add(outputPanel);
		panelEast.setBackground(MEDLOGTAN);

		panelCenter.add(listPanel);
		
		panelSouth.add(searchPanel);
		panelSouth.setBackground(new Color(173, 142, 97));
		frame.add(panelWest, BorderLayout.WEST);
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.add(panelEast, BorderLayout.EAST);
		frame.add(panelSouth, BorderLayout.SOUTH);
		
		frame.setTitle("MedLog System 5000 : : by SilbTech");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 650);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	
	/*
	 * GETTERS AND SETTERS
	 */


	public InputPanel getInputPanel() {
		return inputPanel;
	}

	public void setInputPanel(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	public OutputPanel getOutputPanel() {
		return outputPanel;
	}

	public void setOutputPanel(OutputPanel outputPanel) {
		this.outputPanel = outputPanel;
	}

	public ListPanel getListPanel() {
		return listPanel;
	}

	public void setListPanel(ListPanel listPanel) {
		this.listPanel = listPanel;
	}

	
	
	
}
