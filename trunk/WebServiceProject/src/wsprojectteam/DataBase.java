package wsprojectteam;

import java.util.ArrayList;
import java.util.Hashtable;


public class DataBase {
	private static Hashtable<String,Project> projects = new Hashtable<String,Project>();
	private static Hashtable<String,Auth> users = new Hashtable<String,Auth>();
	
    public String[] getProjects(){
    	String[] retArray = new String[projects.size()];
    	int i = 0;
    	for(String s: projects.keySet()){
    		retArray[i] = s;
    		i++;
    	}
    	
    	return retArray;
    }
    
    public String[] getProjectsForUser(Auth user){
    	ArrayList<String> a = new ArrayList<String>();
    	for(String s: projects.keySet()){
    		if(projects.get(s).hasMember(user.getUsername()))
    			a.add(s);
    	}
    	
    	String[] retArray = new String[a.size()];
    	for(int i=0;i<a.size();i++){
    		retArray[i] = a.get(i);
    	}
    	
    	return retArray;
    }
    
    public boolean addProject(String description, String name){
    	Project p = new Project();
    	p.setDescription(description);
    	p.setName(name);
    	projects.put(name,p);
    	return true;
    }
    
    public boolean addGroupToProject(String description, String project, String name){
    	if(validProject(project) == true){
        	Group g = new Group();
        	g.setName(name);
        	g.setDescription(description);
        	projects.get(project).addGroup(g);
        	return true;
    	}
    	return false;
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
}
