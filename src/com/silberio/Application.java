package com.silberio;

import com.silberio.control.DataAccesObject;
import com.silberio.control.LogSystem;
import com.silberio.control.QueueSysControl;
import com.silberio.control.RepositoryController;
import com.silberio.view.MainWindow;

public class Application {

	public static void main(String[] args) {
		RepositoryController dbControl = RepositoryController.getInstance();
		QueueSysControl queueSys = QueueSysControl.getInstance();
		DataAccesObject dao = DataAccesObject.getInstance();
		LogSystem sys = LogSystem.getInstance();
		
		//Sets up a connection to the Mongo server
		dbControl.establishConnection();
		//Needs implementation = if connection OK proceed - else let user know
		//Maybe with a pop-up. "plz check mongo is run" reconnect, cancel
		// check for MongoSocketOpenException
		
		
		dao.setCol(dbControl.getCollection());
		sys.setDao(dao);
		System.out.println("LogSys Initialized");

		sys.initIterator(dbControl.getDBIterator());
		sys.populateQueue(queueSys);
		dao.setQue(queueSys.getQueue());
		System.out.println("Queue Populated");

		MainWindow gui = new MainWindow();
		gui.setDao(dao);
		gui.populateList(dbControl.getDBIterator());
		System.out.println("GUI Initialized");
		
		//need to add exception handler for empty patient input
	}

}
