package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;

import ar.com.cosgui.services.IServiceLocalImp;

import wsbugtracker.Auth;
import wsbugtracker.Bug;
import wsbugtracker.BugTrackerService;

public class BugTrackerServiceLocalImp implements IServiceLocalImp {

	@Override
	public void connect() {

	}

	public int addUser(String user, String pass) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Bug closeBug(int number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Bug getBug(int number) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] getBugsByProject(String project) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] getBugsByType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Bug submitBug(String description, String type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
