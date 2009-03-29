package ar.com.cosgui.services;

import ar.com.cosgui.datamodel.Bug;

/**
 * Interface que implementara el adapter de BugTracking para adaptarlo a nuestra aplicacion
 * @author Joaquin Alejandro Perez Fuentes
 */
public interface IBugTrackerServiceLocalImp extends IServiceLocalImp{

	public Bug changeBugStatus(int number, String status);
	public Bug getBug(int number);
	public int[] getBugsByProject(String project);
	public int[] getBugsByType(String type);
	public Bug submitBug(String description, String type, String project, String owner);
	
}
