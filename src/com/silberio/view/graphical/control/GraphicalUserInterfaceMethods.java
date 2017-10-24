package com.silberio.view.graphical.control;

public class GraphicalUserInterfaceMethods {

	private static GraphicalUserInterfaceMethods instance = null;
	
	public static GraphicalUserInterfaceMethods getInstance() {
		if(instance == null) {
			instance = new GraphicalUserInterfaceMethods();
		} return instance;
	}
}
