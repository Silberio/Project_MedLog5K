package com.silberio.view.graphical;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainGUIWindow {

	private static InputPanel inputPanel = InputPanel.getInstance();
	private JFrame frame;
	private JPanel panelWest;
	private JPanel panelEast;

	private JPanel buttonPanel = new JPanel();
	private JPanel infoPanel = new PatientFileDisplay();

	private Color medLogTan = new Color(232, 192, 132);

	public MainGUIWindow() {
		initGUI();
		launchFrame();
	}

	private void initGUI() {
		frame = new JFrame(); // default layout manager is BorderLayout
		panelWest = new JPanel();
		panelEast = new JPanel();

		buttonPanel.setBackground(medLogTan);
	}

	private void inputToOuput() {
		JButton btn;
		btn = inputPanel.getInputBtn();
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputPanel.getInputField();
				
			}
		});
		
		
	}

	/**
	 * Launches JFrame with initiated values
	 */
	private void launchFrame() {

		panelWest.add(inputPanel);
		panelWest.setBackground(medLogTan);

		panelEast.add(infoPanel);
		panelEast.setBackground(medLogTan);

		frame.add(panelWest, BorderLayout.WEST);
		frame.add(panelEast, BorderLayout.EAST);

		frame.setTitle("My Frame with Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
