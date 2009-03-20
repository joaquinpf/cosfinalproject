package wsprojectteam;

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
	public boolean addMember(String group, String name){
		if(groups.containsKey(group)){
			groups.get(group).addMember(name);
			return true;
		}
		return false;
	}
}
