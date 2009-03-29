package ar.com.cosgui.services;


/**
 * Interface que implementara el adapter de BugTracking para adaptarlo a nuestra aplicacion
 * @author Joaquin Alejandro Perez Fuentes
 */
public interface IProjectTeamServiceLocalImp extends IServiceLocalImp{

	public boolean addGroupToProject(String description, String project, String name);
	public boolean addMemberToProject(String group,	String project, String name, String password, String description);
	public boolean addProject(String description, String name);
	public String[] getProjects();
	public String[] getProjectsForUser(String user, String pass);
	public String[] getGroupsForProject(String project);
	public String[] getUsersForProject(String project);
	
}
