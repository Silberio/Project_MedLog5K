package com.silberio.view.graphical.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.silberio.view.graphical.model.ListPanel;
import com.silberio.view.graphical.model.SearchPanel;

public class SearchPanelMethods {
	
	/**
	 * click handler for search button
	 * @param btn
	 * @param searchPanel
	 */
	public void searchButtonClickHandler(JButton btn, SearchPanel searchPanel) {
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	
}
