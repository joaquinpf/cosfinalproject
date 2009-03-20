package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;

import ar.com.cosgui.services.IServiceLocalImp;

import wsprojectteam.ProjectTeamService;

public class ProjectTeamServiceLocalImp implements IServiceLocalImp {

	@Override
	public void connect() {

	}

	public String addGroupToProject(String description, String project,
			String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String addMemberToProject(String description, String group,
			String project, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String addProject(String description, String name)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int addUser(String user, String pass) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String[] getProjects() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getProjectsForUser(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}
}
