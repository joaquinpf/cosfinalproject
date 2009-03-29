package ar.com.cosgui.services.imp;

/**
 * Interface a utilizar por Spring para el servicio ProjectTeamService.
 * @author Joaquin Alejandro Perez Fuentes
 */
public interface ProjectTeamIF {
    public Object getProjects() throws java.rmi.RemoteException;
    public Object getProjectsForUser(wsprojectteam.Auth user) throws java.rmi.RemoteException;
    public Object getGroupsForProject(java.lang.String project) throws java.rmi.RemoteException;
    public Object getUsersForProject(java.lang.String project) throws java.rmi.RemoteException;
    public boolean addProject(java.lang.String description, java.lang.String name) throws java.rmi.RemoteException;
    public boolean addGroupToProject(java.lang.String description, java.lang.String project, java.lang.String name) throws java.rmi.RemoteException;
    public boolean addMemberToProject(java.lang.String description, java.lang.String group, java.lang.String project, wsprojectteam.Auth user) throws java.rmi.RemoteException;
    public int addUser(wsprojectteam.Auth user) throws java.rmi.RemoteException;
}