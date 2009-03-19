package wsbugtracker;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;


public class DataBase {
	private static ArrayList<Bug> bugs = new ArrayList<Bug>();
	private static Hashtable<String,Auth> users = new Hashtable<String,Auth>();
	
    public static Bug submitBug(String description, String type, 
    		String owner, String project) {
    	Bug b = new Bug();
    	b.setDescription(description);
    	b.setNumber(bugs.size());
    	b.setOwner(owner);
    	b.setProject(project);
    	b.setType(type);
    	bugs.add(b);
    	return b;
    }

    public static Bug closeBug(int number) {
    	return bugs.remove(number);
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
        return null;
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
