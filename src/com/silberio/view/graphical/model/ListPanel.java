package com.silberio.view.graphical.model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.silberio.model.PatientObject;

public class ListPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MedLogTan MLTAN = new MedLogTan();
	private JList<String> list;
	private DefaultListModel<String> model;
	
	public ListPanel() {
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		model = new DefaultListModel<String>();
	    list = new JList<String>(model);	    
	    JScrollPane pane = new JScrollPane(list);
	    
		this.setBackground(MLTAN);
		this.setLayout(grid);
		this.setBorder(BorderFactory.createEmptyBorder(1, 2, 2, 2));
		this.add(Box.createRigidArea(new Dimension(5, 5)));
		
		pane.setPreferredSize(new Dimension(320,400));
		
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(25);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(pane, gbc);
		}

	/*
	 * GETTERS AND SETTERS 
	 */
	
	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}
	
	

}	
