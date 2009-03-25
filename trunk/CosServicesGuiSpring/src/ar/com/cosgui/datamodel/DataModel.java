package ar.com.cosgui.datamodel;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.HashMap;
import wox.serial.Easy;

/**
 * Clase que maneja el modelo de datos persistente local. Ej: Usuarios locales
 * @author Joaquin Alejandro Perez Fuentes
 */
public class DataModel {

	/**
	 * Instancia del singleton
	 */
    public static DataModel INSTANCE = new DataModel();

    /**
     * Usuarios y contraseñas
     */
    private HashMap<String,String> users = new HashMap<String, String>();

    /**
     * Usuario activo del sistema
     */
    private String activeUser = new String();

    /**
     * Constructor de la clase. Protegido para implementacion de singleton
     */
    protected DataModel(){
        loadUsers();
    }

    /**
     * Serializa la tabla de hash de usuarios a XML via WOX
     */
	private void saveUsers() {
		Easy.save(users, "./config/users.xml");
	}
	
	/**
	 * Carga los usuarios del XMl provisto, si este existe.
	 */
	@SuppressWarnings("unchecked")
	private void loadUsers() {
		File f = new File("./config/users.xml");
		if (f.exists()) {
			users = (HashMap<String,String>)Easy.load("./config/users.xml");
		}
	}

	/**
	 * Devuelve true si el usuario @param key existe
	 * @param key
	 * @return
	 */
    public boolean existUser(String key) {
        return users.containsKey(key);
    }

    /**
     * Agrega un par usuario-contraseña al sistema
     * @param key
     * @param value
     * @return
     */
    public String addUser(String key, String value) {
        if(existUser(key)){
        	return "Username already exists";
        }
    	users.put(key, value);
        saveUsers();
        return "User created succesfully";
    }
 
    /**
     * Valida la identidad de un usuario
     * @param key
     * @param value
     * @return
     */
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

	/**
	 * Obtiene el password del usuario activo
	 * @return
	 */
	public String getActiveUserPass() {
		if(activeUser != null)
			return users.get(activeUser);
		else
			return null;
	}
    
}
