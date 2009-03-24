package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;
import java.util.ArrayList;

import wsprojectteam.Auth;
import ar.com.cosgui.services.IServiceLocalImp;

public class ProjectTeamServiceLocalImp implements IServiceLocalImp {

	private ProjectTeamIF proxy = null;
	
	public ProjectTeamIF getProxy() {
		return proxy;
	}

	public void setProxy(ProjectTeamIF proxy) {
		this.proxy = proxy;
	}

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
			return toStringArray(proxy.getProjects());
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private String[] toStringArray(Object array) {
		if(array instanceof String){
			String[] ret = new String[1];
			ret[0] = (String) array; 
			return ret;
		} else if(array instanceof ArrayList){
			if(array!=null)	{
				String[] retStringuized = new String[((ArrayList<String>) array).size()];
				return ((ArrayList<String>) array).toArray(retStringuized);
			}
		}
		return null;
	}
			
			
	public String[] getProjectsForUser(String user, String pass) {
		try {
			Auth a = new Auth();
			a.setPass(pass);
			a.setUsername(user);
			return toStringArray(proxy.getProjectsForUser(a));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String[] getGroupsForProject(String project){
		try {
			return toStringArray(proxy.getGroupsForProject(project));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}	   
}
