package ar.com.cosgui.services.imp;

import java.rmi.RemoteException;

import ar.com.cosgui.services.IServiceLocalImp;
import wschat.Auth;
import wschat.ChatServiceProxy;
import wschat.TextMessage;


public class ChatServiceLocalImp implements IServiceLocalImp {
	private ChatServiceProxy service = new ChatServiceProxy();

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

	public int login(String user, String pass) {
    	try {
			return service.login (new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public int logout(String user, String pass) {
    	try {
			return service.logout (new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public int sendMessage(String message, String usernameSrc, String usernameDst) {
    	try {
			return service.sendMessage (new TextMessage(message, usernameSrc, usernameDst));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public java.lang.String[] getContacts(String username) {
    	try {
			return service.getContacts (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	public int addContact(String username, String contact) {
    	try {
			if (!username.equals(contact))
				return service.addContact (username, contact);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public java.lang.String[] receiveMessage(String username) {
    	try {
			return service.receiveMessage (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	public int getStatus(String username) {
    	try {
			return service.getStatus (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
	public int existUserName(String username) {
    	try {
			return service.existUserName (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	  
}
