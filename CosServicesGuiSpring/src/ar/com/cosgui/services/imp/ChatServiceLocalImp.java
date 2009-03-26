package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.com.cosgui.services.IServiceLocalImp;
import wschat.Auth;
import wschat.ChatServiceProxy;
import wschat.TextMessage;


public class ChatServiceLocalImp implements IServiceLocalImp {
	private ChatIF service = null;

	public ChatIF getService() {
		return service;
	}

	public void setService(ChatIF service) {
		this.service = service;
	}

	@Override
	public void connect() {

	}

	@Override
	public int addUser(String user, String pass) {
    	try {
			if (this.existUserName(user) == 0)
				return service.addUser(new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int login(String user, String pass) throws java.rmi.RemoteException{
    	try {
			return service.login (new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public int logout(String user, String pass) throws java.rmi.RemoteException{
    	try {
			return service.logout (new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public int sendMessage(String message, String usernameSrc, String usernameDst) throws java.rmi.RemoteException{
    	try {
			return service.sendMessage (new TextMessage(message, usernameSrc, usernameDst));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public java.lang.String[] getContacts(String username) throws java.rmi.RemoteException{
    	try {
			return toStringArray(service.getContacts (username));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	public int addContact(String username, String contact) throws java.rmi.RemoteException{
    	try {
			if (!username.equals(contact))
				return service.addContact (username, contact);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public java.lang.String[] receiveMessage(String username) throws java.rmi.RemoteException{
    	try {
			return toStringArray(service.receiveMessage (username));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	public int getStatus(String username) throws java.rmi.RemoteException{
    	try {
			return service.getStatus (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public int existUserName(String username) throws java.rmi.RemoteException{
    	try {
			return service.existUserName (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	@SuppressWarnings("unchecked")
	private String[] toStringArray(Object array) {
		if(array instanceof String){
			String[] ret = new String[1];
			ret[0] = (String) array; 
			return ret;
		} else if(array instanceof ArrayList){
			if(array!=null)	{
				String[] retStringuized = new String[((ArrayList<String>) array).size()];
				return ((ArrayList<String>) array).toArray(retStringuized);
			}
		}
		return null;
	}
	
}
