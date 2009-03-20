package wsprojectteam;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import wsprojectteam.Auth;
import wsprojectteam.Project;


public class DataBase {
	private static Hashtable<String,Project> projects = new Hashtable<String,Project>();
	private static Hashtable<String,Auth> users = new Hashtable<String,Auth>();
	
    public String[] getProjects(){
    	
    }
    
    public String[] getProjectsForUser(Auth user){
    	
    }
    
    public boolean addProject(String description, String name){
    	Project p = new Project();
    	p.setDescription(description);
    	p.setName(name);
    	projects.put(name,p);
    	return true;
    }
    
    public String addGroupToProject(String description, String project, String name){
    	
    }
    
    public boolean addMemberToProject(String description, String group, String project, Auth user){
    	if(validUser(user)==true && validProject(project)==true){
    		projects.get(project).addMember(group, user.getUsername());
    		return true;
    	}
		return false;
    }
    
	private boolean validProject(String project) {
		if(projects.containsKey(project)){
			return true;
		}
		return false;
	}
	private static boolean validUser(Auth user){
		if(users.containsKey(user.getUsername()) == true){
			if(users.get(user.getUsername()).getPass().equals(user.getPass())){
				return true;
			}
		}
		return false;
	}

	public static int addUser(Auth user) {
		int valid = 0;
		if (users.containsKey(user.getUsername()) == false) {
			users.put(user.getUsername(),user);
			valid = 1;
		}
		return valid;
	}
	
	
	
    public static Bug submitBug(String description, String type, 
    		String owner, String project) {
    	Bug b = new Bug();
    	b.setDescription(description);
    	b.setNumber(bugs.size());
    	b.setOwner(owner);
    	b.setProject(project);
    	b.setType(type);
    	b.setStatus("Submitted");
    	bugs.add(b);
    	return b;
    }

    public static Bug closeBug(int number) {
    	getBug(number).setStatus("Submitted");
    }

    public static Bug getBug(int number) {
    	if(bugs.size() > number){
    		return bugs.get(number);
    	} else {
    		return null;
    	}
    }

    public static int[] getBugsByType(String type) {
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	for(int i=0;i<bugs.size();i++){
    		if(bugs.get(i).getType().equals(type)){
    			a.add(i);
    		}
    	}
    	int[] retArray = new int[a.size()];
    	for(int i=0;i<a.size();i++){
    		retArray[i] = a.get(i);
    	}
    	
    	return retArray;
    }

	public static int[] getBugsByProject(String project) {
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	for(int i=0;i<bugs.size();i++){
    		if(bugs.get(i).getProject().equals(project)){
    			a.add(i);
    		}
    	}
    	int[] retArray = new int[a.size()];
    	for(int i=0;i<a.size();i++){
    		retArray[i] = a.get(i);
    	}
    	
    	return retArray;
    }
/*
	private static Hashtable<String, ArrayList<String>> projects = new Hashtable<String, ArrayList<String>>();
	public static String[] getMails(Auth user){
		if (validUser(user) == true){
			ArrayList<String> userProjects = projects.get(user.getUsername());
			String[] returnProjects = new String[userProjects.size()];

			for(int i=0;i<userProjects.size();i++)
				returnProjects[i] = userProjects.get(i);
			return returnProjects;
		}
		else
			return null;
	}
	*/
}
