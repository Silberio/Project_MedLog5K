package com.silberio.view.graphical.model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {
	
	private static SearchPanel instance = null;
	
	public static SearchPanel getInstance() {
		if(instance == null) {
			instance = new SearchPanel();
		} return instance;
	}
	
	private final MedLogTan MLTAN = new MedLogTan();
	private JButton searchButton;
	private JLabel label;
	private JComboBox<String> searchCategory;
	private JTextField searchBar;
	private String[] category = {"Last name", "First name", "Doctor", "Birth date"};
	
	public SearchPanel() {
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		this.setBackground(MLTAN);
		this.setLayout(grid);
		this.setBorder(BorderFactory.createEmptyBorder(1, 2, 2, 2));
		this.add(Box.createRigidArea(new Dimension(0, 5)));
		
		gbc.insets = new Insets(2, 5, 2, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(label = new JLabel("Search By: "), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(searchCategory = new JComboBox<String>(category), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		this.add(searchBar = new JTextField(10), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		this.add(searchButton = new JButton("Search File"), gbc);
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public JComboBox getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(JComboBox searchCategory) {
		this.searchCategory = searchCategory;
	}

	public JTextField getSearchBar() {
		return searchBar;
	}

	public void setSearchBar(JTextField searchBar) {
		this.searchBar = searchBar;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}
	
	
}
