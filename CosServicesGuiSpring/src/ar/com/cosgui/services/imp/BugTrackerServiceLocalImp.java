package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;
import java.util.ArrayList;

import wsbugtracker.Auth;
import wsbugtracker.Bug;
import ar.com.cosgui.services.IServiceLocalImp;

/**
 * Implementacion via Spring del servicio de Bug Tracking.
 * @author Joaquin Alejandro Perez Fuentes
 */
public class BugTrackerServiceLocalImp implements IServiceLocalImp {

	private BugTrackerIF wsbugtracker = null;

	public void setWsbugtracker(BugTrackerIF wsbugtracker) {
		this.wsbugtracker = wsbugtracker;
	}

	public BugTrackerIF getWsbugtracker() {
		return wsbugtracker;
	}
	
	@Override
	public void connect() {
		
	}

	public int addUser(String user, String pass) {
		Auth a = new Auth();
		a.setPass(pass);
		a.setUsername(user);
		try {
			return wsbugtracker.addUser(a);
		} catch (RemoteException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public Bug changeBugStatus(int number, String status) {
		try {
			return wsbugtracker.changeBugStatus(number, status);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Bug getBug(int number) {
		try {
			return wsbugtracker.getBug(number);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int[] getBugsByProject(String project) {
		try {
			return toIntArray(wsbugtracker.getBugsByProject(project));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int[] getBugsByType(String type) throws RemoteException {
		try {
			return toIntArray(wsbugtracker.getBugsByType(type));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private int[] toIntArray(Object array) {
		if(array instanceof Integer){
			int[] ret = new int[1];
			ret[0] = (Integer) array; 
			return ret;
		} else if(array instanceof ArrayList){
			if(array!=null)	{
				int[] retInteguerized = new int[((ArrayList<Integer>) array).size()];
				for(int i=0; i<((ArrayList<Integer>) array).size(); i++){
					retInteguerized[i]=((ArrayList<Integer>) array).get(i);
				}
				return retInteguerized;
			}
		}
		return null;
	}

	public Bug submitBug(String description, String type, String project, String owner) {
		try {
			return wsbugtracker.submitBug(description, type,owner , project, "Open");
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
