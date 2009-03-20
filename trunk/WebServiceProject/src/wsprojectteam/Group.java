package wsprojectteam;

import java.util.HashSet;

public class Group {
	private String name;
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
}
