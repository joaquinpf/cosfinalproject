package wsprojectteam;

import java.util.HashSet;

public class Group {
	private String name;
	private String description;
	private HashSet<String> members = new HashSet<String>();
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setMembers(HashSet<String> members) {
		this.members = members;
	}
	public HashSet<String> getMembers() {
		return members;
	} 
	public void addMember(String name){
		members.add(name);
	}
	public boolean hasMember(String name) {
		return (members.contains(name) == true) ? true:false; 
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
