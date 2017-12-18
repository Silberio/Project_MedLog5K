package com.silberio.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainWindow extends JFrame {

	/**
	 * Initializes main GUI frame
	 */
	private JPanel center, east, south;
	private GridBagLayout grid = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private static InputField fname, lname, address, dob, phone, presc, sig;
	private static JTextArea prescreason;
	
	public MainWindow() {
		this.setTitle("MedLog System 5000 : : by SilbTech");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 650);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	
		this.add(container());
		
		center.add(new JLabel("center"));
		east.add(new JLabel("east"));
		south.add(new JLabel("south"));
	}
	
	private JPanel container() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(west(), BorderLayout.WEST);
		
		container.add(center = new JPanel(), BorderLayout.CENTER);
		container.add(east = new JPanel(), BorderLayout.EAST);
		container.add(south = new JPanel(), BorderLayout.SOUTH);
		center.setBackground(new Color(232, 192, 132));	
		
		return container;
	}
	
	private JPanel west() {
		JPanel west = new JPanel();
		
		west.setLayout(grid);
		
//		this.add(Box.createRigidArea(new Dimension(0, 5)));

		gbc.insets = new Insets(2, 5, 2, 2);
		
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = 0;
		gbc.gridy = 0;	
		west.add(new JLabel("Name: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;	
		west.add(fname = new InputField("fname"), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;	
		west.add(lname = new InputField("lname"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;	
		west.add(new JLabel("Address: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;	
		west.add(address = new InputField("address"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;	
		west.add(new JLabel("D.O.B.: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;	
		west.add(dob = new InputField("dob"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;	
		west.add(new JLabel("Phone: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;	
		west.add(phone = new InputField("phone"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;	
		west.add(new JLabel("Prescription: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;	
		west.add(presc = new InputField("prescription"), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		west.add(new JLabel("Prescription Reason: "));
		gbc.gridx = 1;
		gbc.gridy = 6;
		west.add(prescreason = new JTextArea(10,15));

		return west;
	}
	
}
