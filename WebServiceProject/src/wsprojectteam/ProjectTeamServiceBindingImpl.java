/**
 * ProjectTeamServiceBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsprojectteam;

public class ProjectTeamServiceBindingImpl implements wsprojectteam.ProjectTeamService{
    public java.lang.String[] getProjects() throws java.rmi.RemoteException {
        return DataBase.getProjects();
    }

    public java.lang.String[] getUsersForProject(java.lang.String project) throws java.rmi.RemoteException {
        return DataBase.getUsersForProject(project);
    }

    public java.lang.String[] getProjectsForUser(wsprojectteam.Auth user) throws java.rmi.RemoteException {
        return DataBase.getProjectsForUser(user);
    }

    public java.lang.String[] getGroupsForProject(java.lang.String project) throws java.rmi.RemoteException {
        return DataBase.getGroupsForProject(project);
    }

    public boolean addProject(java.lang.String description, java.lang.String name) throws java.rmi.RemoteException {
        return DataBase.addProject(description, name);
    }

    public boolean addGroupToProject(java.lang.String description, java.lang.String project, java.lang.String name) throws java.rmi.RemoteException {
        return DataBase.addGroupToProject(description, project, name);
    }

    public boolean addMemberToProject(java.lang.String description, java.lang.String group, java.lang.String project, wsprojectteam.Auth user) throws java.rmi.RemoteException {
        return DataBase.addMemberToProject(description, group, project, user);
    }

    public int addUser(wsprojectteam.Auth user) throws java.rmi.RemoteException {
        return DataBase.addUser(user);
    }

}
