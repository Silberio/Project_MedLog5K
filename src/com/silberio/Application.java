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

		dbControl.establishConnection();

		dao.setCol(dbControl.getCollection());
		sys.setDao(dao);
		sys.setQueueSys(queueSys);
		System.out.println("LogSys Initialized");

		sys.initIterator(dbControl.getCollection());
		sys.populateQueue();
		dao.setQue(queueSys.getQueue());
		System.out.println("Queue Populated");

		MainWindow gui = new MainWindow();
		gui.setDao(dao);
		System.out.println("GUI Initialized");
		
	}

}
