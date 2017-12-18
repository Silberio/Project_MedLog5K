package com.silberio;

import com.silberio.control.LogSystem;
import com.silberio.control.RepositoryController;
import com.silberio.view.MainWindow;

public class Application {

	public static void main(String[] args) {
		RepositoryController dbControl = RepositoryController.getInstance();
		dbControl.establishConnection();
		
		LogSystem sys = LogSystem.getInstance();
		System.out.println("LogSys Initialized");
		
//		sys.initIterator(dbControl.getCollection());
//		sys.populateQueue();
		
		MainWindow gui = new MainWindow();
	}

}
