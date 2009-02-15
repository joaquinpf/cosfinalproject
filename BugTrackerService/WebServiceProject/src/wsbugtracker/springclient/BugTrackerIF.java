package wsbugtracker.springclient;

import java.rmi.RemoteException;

import wsbugtracker.Bug;

public interface BugTrackerIF {
	public Bug submitBug(String description, String type) throws RemoteException;
	public Bug closeBug(int number) throws RemoteException;
	public Bug getBug(int number) throws RemoteException;
	public int[] getBugsByType(String type) throws RemoteException;
}