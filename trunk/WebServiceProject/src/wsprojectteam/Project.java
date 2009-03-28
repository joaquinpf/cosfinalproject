package wsprojectteam;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
	private HashMap<String, Group> groups = new HashMap<String, Group>();
	private String description;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	public void setGroups(HashMap<String, Group> groups) {
		this.groups = groups;
	}
	public HashMap<String, Group> getGroups() {
		return groups;
	}	
	
	public boolean addGroup(Group g){
		if(groups.containsKey(g.getName())==false){
			this.groups.put(g.getName(), g);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addMember(String group, String name){
		if(groups.containsKey(group)){
			groups.get(group).addMember(name);
			return true;
		}
		return false;
	}
	public boolean hasMember(String name){
		for(String g: groups.keySet()){
			if(groups.get(g).hasMember(name) == true){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<String> getUsers(){
		ArrayList<String> users = new ArrayList<String>();
		for(String g: groups.keySet()){
			for(String user:groups.get(g).getMembers()){
				if(users.contains(user) == false){
					users.add(user);
				}
			}
		}
		return users;
	}
}
