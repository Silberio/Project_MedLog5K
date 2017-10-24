package com.silberio.controller;

import com.silberio.model.PatientObject;
import com.silberio.view.graphical.MainGUIWindow;
import com.silberio.view.graphical.model.GUIArray;

public class MedLogApplication {
	public static void main(String[] args) {
		
		LogSystem logSys = LogSystem.getInstance();

		

		logSys.mainframe();
//		logSys.printDocuments();
	
			
	}
}
