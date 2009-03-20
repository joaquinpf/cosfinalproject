package ar.com.cosgui.datamodel;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.HashMap;
import wox.serial.Easy;

/**
 *
 * @author Kireta
 */
public class DataModel {

    public static DataModel INSTANCE = new DataModel();

    private HashMap<String,String> users = new HashMap<String, String>();

    private String activeUser = new String();
    
    protected DataModel(){
        loadUsers();
    }

	private void saveUsers() {
		Easy.save(users, "./config/users.xml");
	}

	@SuppressWarnings("unchecked")
	private void loadUsers() {
		File f = new File("./config/users.xml");
		if (f.exists()) {
			users = (HashMap<String,String>)Easy.load("./config/users.xml");
		}
	}

    public boolean existUser(String key) {
        return users.containsKey(key);
    }

    public String addUser(String key, String value) {
        if(existUser(key)){
        	return "Username already exists";
        }
    	users.put(key, value);
        saveUsers();
        return "User created succesfully";
    }
    
    public boolean validateUser(String key, String value){
    	if (existUser(key)){
    		if(users.get(key).equals(value)){
    			return true;
    		}
    	}
    	return false;
    }

	public void setActiveUser(String activeUser) {
		this.activeUser = activeUser;
	}

	public String getActiveUser() {
		return activeUser;
	}
    
}
