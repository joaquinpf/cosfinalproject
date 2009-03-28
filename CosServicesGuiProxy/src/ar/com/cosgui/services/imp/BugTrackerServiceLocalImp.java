package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;

import wsbugtracker.Auth;
import wsbugtracker.BugTrackerServiceProxy;
import ar.com.cosgui.datamodel.Bug;
import ar.com.cosgui.services.IServiceLocalImp;

/**
 * Implementacion via Proxys del servicio de Bug Tracking.
 * @author Joaquin Alejandro Perez Fuentes
 */
public class BugTrackerServiceLocalImp implements IServiceLocalImp {

	/**
	 * Proxy del servicio
	 */
	BugTrackerServiceProxy proxy = new BugTrackerServiceProxy();
	
	@Override
	public void connect() {
		
	}

	public int addUser(String user, String pass) {
		Auth a = new Auth();
		a.setPass(pass);
		a.setUsername(user);
		try {
			return proxy.addUser(a);
		} catch (RemoteException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public Bug changeBugStatus(int number, String status) {
		try {
			return LocalBuguize(proxy.changeBugStatus(number, status));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Bug getBug(int number) {
		try {
			return LocalBuguize(proxy.getBug(number));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int[] getBugsByProject(String project) {
		try {
			return proxy.getBugsByProject(project);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int[] getBugsByType(String type) throws RemoteException {
		try {
			return proxy.getBugsByType(type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Bug submitBug(String description, String type, String project, String owner) {
		try {
			return LocalBuguize(proxy.submitBug(description, type,owner , project, "Open"));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	private Bug LocalBuguize(wsbugtracker.Bug submitBug) {
		Bug b = new Bug();
		b.setDescription(submitBug.getDescription());
		b.setNumber(submitBug.getNumber());
		b.setOwner(submitBug.getOwner());
		b.setProject(submitBug.getProject());
		b.setStatus(submitBug.getStatus());
		b.setType(submitBug.getType());
		return b;
	}
	
}
