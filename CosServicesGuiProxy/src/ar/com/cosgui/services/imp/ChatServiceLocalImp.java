package ar.com.cosgui.services.imp;

import ar.com.cosgui.services.IServiceLocalImp;
import wschat.ChatServiceProxy;


public class ChatServiceLocalImp implements IServiceLocalImp {
	private ChatServiceProxy service = new ChatServiceProxy();

	@Override
	public void connect() {

	}

	@Override
	public int addUser(String user, String pass) {
    	try {
			if (this.validUserName(user) == 0)
				return service.addUserMail(new Auth(user, pass));
			else 
				return 0;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public int login(String user, String pass) throws java.rmi.RemoteException{
    	try {
			return service.login (new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	  
	public int logout(String user, String pass) throws java.rmi.RemoteException{
    	try {
			return service.logout (new Auth(user, pass));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	  
	public int sendMessage(String message, String usernameSrc, String usernameDst) throws java.rmi.RemoteException{
    	try {
			return service.sendMessage (new TextMessage(message, usernameSrc, usernameDst));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	  
	public java.lang.String[] getContacts(String username) throws java.rmi.RemoteException{
    	try {
			return service.getContacts (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	  
	public int addContact(String username, String contact) throws java.rmi.RemoteException{
    	try {
			if (!username.equals(contact))
				return service.addContact (username, contact);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	  
	public java.lang.String[] receiveMessage(String username) throws java.rmi.RemoteException{
    	try {
			return service.receiveMessage (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	  
	public int getStatus(String username) throws java.rmi.RemoteException{
    	try {
			return service.getStatus (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	  
	public int existUserName(String username) throws java.rmi.RemoteException{
    	try {
			return service.existUserName (username);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	  
}
