package wsbugtracker;

import java.util.ArrayList;
import java.util.Hashtable;


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
    	b.setStatus("Open");
    	bugs.add(b);
    	return b;
    }

    public static Bug changeBugStatus(int number, String status) {
    	Bug b = getBug(number);
    	if(b != null){
    		b.setStatus(status);
    	}
    	return b;
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
