package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;

import wsprojectteam.Auth;
import wsprojectteam.ProjectTeamServiceProxy;

import ar.com.cosgui.services.IServiceLocalImp;

/**
 * Implementacion via Proxys del servicio ProjectTeamService.
 * @author Joaquin Alejandro Perez Fuentes
 */
public class ProjectTeamServiceLocalImp implements IServiceLocalImp {

	ProjectTeamServiceProxy proxy = new ProjectTeamServiceProxy();

	@Override
	public void connect() {
		
	}

	public boolean addGroupToProject(String description, String project,
			String name) {
		try {
			return proxy.addGroupToProject(description, project, name);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addMemberToProject(String group,
			String project, String name, String password, String description) {
		try {
			Auth a = new Auth();
			a.setPass(password);
			a.setUsername(name);
			return proxy.addMemberToProject(description, group, project, a);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addProject(String description, String name) {
		try {
			return proxy.addProject(description, name);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int addUser(String user, String pass) {
		try {
			Auth a = new Auth();
			a.setPass(pass);
			a.setUsername(user);
			return proxy.addUser(a);
		} catch (RemoteException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String[] getProjects() {
		try {
			return proxy.getProjects();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] getProjectsForUser(String user, String pass) {
		try {
			Auth a = new Auth();
			a.setPass(pass);
			a.setUsername(user);
			return proxy.getProjectsForUser(a);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String[] getGroupsForProject(String project){
		try {
			return proxy.getGroupsForProject(project);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}	   
}
